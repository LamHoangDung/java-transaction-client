package com.example.transaction_service.dto;


import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class InquiryResponse {
    String transactionId;
    String status;
}
