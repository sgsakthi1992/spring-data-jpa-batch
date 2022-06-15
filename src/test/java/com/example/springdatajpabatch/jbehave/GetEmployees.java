package com.example.springdatajpabatch.jbehave;

import com.example.springdatajpabatch.domain.Employee;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.util.EntityUtils;
import org.jbehave.core.annotations.Given;
import org.jbehave.core.annotations.Then;
import org.jbehave.core.annotations.When;

import java.io.IOException;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;


public class GetEmployees {

    private String api;
    private List<Employee> employees;

    @Given("the api to get all the employees")
    public void givenTheFindAllAPI() {
        api = "http://localhost:8082/api/v1/employees";
    }

    @When("the find all api is triggered")
    public void whenFindAllAPIIsTriggered() throws IOException {
        var response = getFindAll(api);
        employees = retrieveResourceFromResponse(response, Employee.class);
    }

    @Then("employees should be retrieved from database")
    public void theEmployeesShouldBeReturnedFromDatabase() {
        assertTrue(employees.size() > 1);
        assertEquals("Malli", employees.get(0).firstName);
        assertEquals("Bandi", employees.get(0).lastName);
        assertEquals("10-11-1989", employees.get(0).dateOfBirth);
    }

    private static HttpResponse getFindAll(String api) throws IOException {
        var request = new HttpGet(api);
        return HttpClientBuilder.create().build().execute(request);
    }

    public static <T> List<T> retrieveResourceFromResponse(final HttpResponse response, final Class<T> clazz) throws IOException {
        var jsonFromResponse = EntityUtils.toString(response.getEntity());
        var mapper = new ObjectMapper().configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        return mapper.readValue(jsonFromResponse, mapper.getTypeFactory().constructCollectionType(List.class, clazz));
    }
}
