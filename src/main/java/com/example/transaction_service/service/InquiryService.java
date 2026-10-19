package com.example.transaction_service.service;

import com.example.transaction_service.dto.InquiryResponse;
import com.example.transaction_service.entity.TransactionEntity;
import com.example.transaction_service.repository.TransactionRepository;
import com.example.transaction_service.request.InquiryRequest;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.server.ResponseStatusException;

import java.util.Optional;

@Service
public class InquiryService {

    private TransactionRepository transactionRepository;
    public InquiryService(TransactionRepository transactionRepository) {
        this.transactionRepository = transactionRepository;
    }
    @Transactional
    public InquiryResponse checkTransaction(InquiryRequest request){
        Optional<TransactionEntity> transactionEntity = transactionRepository.findByTransactionId(request.getTransactionId());
        if (transactionEntity.isEmpty()) {
            System.out.println("ko tim thay giao dich");
            return null;
        }
        TransactionEntity transaction = transactionEntity.get();
        InquiryResponse inquiryResponse = new InquiryResponse();
        inquiryResponse.setStatus(transaction.getStatus());
        inquiryResponse.setTransactionId(transaction.getTransactionId());
        return inquiryResponse;
    }
}