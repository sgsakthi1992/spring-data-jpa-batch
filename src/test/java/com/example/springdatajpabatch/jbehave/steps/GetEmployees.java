package com.example.springdatajpabatch.jbehave.steps;

import com.example.springdatajpabatch.domain.Employee;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.util.EntityUtils;
import org.jbehave.core.annotations.Given;
import org.jbehave.core.annotations.Then;
import org.jbehave.core.annotations.When;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.time.LocalDate;
import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

@Component
public class GetEmployees {

    private String api;
    private List<Employee> employees;

    @Given("the api to get all the employees")
    public void givenTheApiToGetAllTheEmployees() {
        api = "http://localhost:8082/api/v1/employees";
    }

    @When("the find all api is triggered")
    public void whenTheFindAllApiIsTriggered() throws IOException {
        var response = getFindAll(api);
        employees = retrieveResourceFromResponse(response, Employee.class);
    }

    @Then("employees should be retrieved from database $value")
    public void thenEmployeesShouldBeRetrievedFromDatabase(String value) throws JsonProcessingException {
        var expected = convertToList(Employee.class, value);
        assertThat(expected, equalTo(employees));
        assertTrue(employees.size() > 1);
        assertEquals("Malli", employees.get(0).firstName);
        assertEquals("Bandi", employees.get(0).lastName);
        assertEquals(LocalDate.of(2012, 3, 15), employees.get(0).dateOfJoin);
    }

    private static HttpResponse getFindAll(String api) throws IOException {
        var request = new HttpGet(api);
        return HttpClientBuilder.create().build().execute(request);
    }

    public static <T> List<T> retrieveResourceFromResponse(final HttpResponse response, final Class<T> clazz) throws IOException {
        var jsonFromResponse = EntityUtils.toString(response.getEntity());
        return convertToList(clazz, jsonFromResponse);
    }

    private static <T> List<T> convertToList(Class<T> clazz, String jsonFromResponse) throws JsonProcessingException {
        var mapper = new ObjectMapper()
                .registerModule(new JavaTimeModule())
                .configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        return mapper.readValue(jsonFromResponse, mapper.getTypeFactory().constructCollectionType(List.class, clazz));
    }
}
