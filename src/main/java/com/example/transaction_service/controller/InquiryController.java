package com.example.transaction_service.controller;

import com.example.transaction_service.dto.InquiryResponse;
import com.example.transaction_service.request.InquiryRequest;
import com.example.transaction_service.service.InquiryService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/transactions")
public class InquiryController {

    private final InquiryService inquiryService;

    public InquiryController(InquiryService inquiryService) {
        this.inquiryService = inquiryService;
    }

    @PostMapping("/inquiry")
    public InquiryResponse checkTransaction(@RequestBody InquiryRequest request) {
        return inquiryService.checkTransaction(request);
    }
}