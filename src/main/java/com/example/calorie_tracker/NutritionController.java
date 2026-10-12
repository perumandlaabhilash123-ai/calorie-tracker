package com.example.calorie_tracker;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestClient;
import org.springframework.web.client.RestClientException;
import org.springframework.web.server.ResponseStatusException;

@RestController
@RequestMapping("/api/nutrition")
public class NutritionController {

    private final RestClient client;
    private final String apiKey;

    public NutritionController(@Value("${usda.api.key}") String apiKey) {
        this.apiKey = apiKey;
        this.client = RestClient.builder()
                .baseUrl("https://api.nal.usda.gov/fdc/v1")
                .build();
    }

    @GetMapping(value = "/search", produces = MediaType.APPLICATION_JSON_VALUE)
    public String search(@RequestParam("query") String query) {
        String foodName = query.trim();

        if (foodName.isEmpty() || foodName.length() > 100) {
            throw new ResponseStatusException(
                    HttpStatus.BAD_REQUEST,
                    "Enter a food name between 1 and 100 characters."
            );
        }

        try {
            return client.get()
                    .uri(builder -> builder
                            .path("/foods/search")
                            .queryParam("api_key", apiKey)
                            .queryParam("query", "{food}")
                            .queryParam("dataType", "Foundation,SR Legacy")
                            .queryParam("pageSize", 10)
                            .build(foodName))
                    .retrieve()
                    .body(String.class);
        } catch (RestClientException exception) {
            throw new ResponseStatusException(
                    HttpStatus.BAD_GATEWAY,
                    "Food search failed. Check your USDA key and internet connection."
            );
        }
    }
}