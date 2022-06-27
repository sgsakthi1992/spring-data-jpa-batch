package com.example.springdatajpabatch.controller;

import com.example.springdatajpabatch.model.HeaderRequest;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class HeaderRequestConverter implements Converter<String, HeaderRequest>{
    public HeaderRequest convert(String jsonHeader) {
        try {
            return new ObjectMapper().readValue(jsonHeader, HeaderRequest.class);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }
}
