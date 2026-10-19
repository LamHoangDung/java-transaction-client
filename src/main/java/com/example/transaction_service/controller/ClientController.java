package com.example.transaction_service.controller;

import com.example.transaction_service.dto.InquiryResponse;
import com.example.transaction_service.request.InquiryRequest;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClient;

@Service
public class ClientController {
    private final RestClient restClient = RestClient.create("http://localhost:8081");
    public InquiryResponse inquire(InquiryRequest request) {
        return restClient.post()
                .uri("/api/transactions/inquiry")
                .contentType(MediaType.APPLICATION_JSON)
                .body(request)
                .retrieve()
                .body(InquiryResponse.class);
    }
}