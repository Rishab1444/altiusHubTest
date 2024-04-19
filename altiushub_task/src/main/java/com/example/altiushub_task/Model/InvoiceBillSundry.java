package com.example.altiushub_task.Model;

import jakarta.persistence.*;
import lombok.Data;

import java.math.BigDecimal;
import java.util.UUID;

/*
Id: UUID
billSundryName: string
Amount: decimal

 */
@Entity
@Data
public class InvoiceBillSundry {

        @Id
        @GeneratedValue(strategy = GenerationType.AUTO)
        private UUID id;
        private String billSundryName;
        private BigDecimal amount;

        @ManyToOne
        @JoinColumn(name = "invoice_header_id")
        private InvoiceHeader invoiceHeader;

}
