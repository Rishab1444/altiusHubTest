package com.example.altiushub_task.Model;

import jakarta.persistence.*;
import lombok.Data;

import java.math.BigDecimal;
import java.util.UUID;

/*
Id: UUID
itemName: string
Quantity: decimal
Price: decimal
Amount: decimal
*/

@Entity
@Data
public class InvoiceItem {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;
    private String itemName;
    private BigDecimal quantity;
    private BigDecimal price;
    private BigDecimal amount;

    @ManyToOne
    @JoinColumn(name = "invoice_header_id")
    private InvoiceHeader invoiceHeader;
}
