package com.example.transaction_service;

import com.example.transaction_service.controller.ClientController;
import com.example.transaction_service.dto.InquiryResponse;
import com.example.transaction_service.request.InquiryRequest;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.Scanner;

@Component
public class InquiryMain implements CommandLineRunner {

    private final ClientController clientController;

    public InquiryMain(ClientController clientController) {
        this.clientController = clientController;
    }

    @Override
    public void run(String... args) {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("Nhập mã giao dịch, hoặc nhập exit để dừng:");
            String transactionId = scanner.nextLine().trim();
            if ("exit".equalsIgnoreCase(transactionId)) {
                break;
            }
            if (transactionId.isEmpty()) {
                System.out.println("nhap ma GD");
                continue;
            }
            InquiryRequest request = new InquiryRequest();
            request.setTransactionId(transactionId);

            try {
                InquiryResponse response = clientController.inquire(request);
                System.out.println("Mã giao dịch: " + response.getTransactionId());
                System.out.println("Trạng thái: " + response.getStatus());
            } catch (Exception exception) {
                System.out.println(
                        "Gọi API thất bại: " + exception.getMessage()
                );
            }
        }
    }
}