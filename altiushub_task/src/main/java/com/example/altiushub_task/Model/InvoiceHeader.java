package com.example.altiushub_task.Model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.Generated;

import java.math.BigDecimal;
import java.util.List;
import java.util.UUID;

/*
* Id: UUID
Date: string (UTC)
InvoiceNumber: number
CustomerName: string
BillingAddress: string
ShippingAddress: string
GSTIN: string
TotalAmount: Decimal
*/
@Entity
@Data
public class InvoiceHeader {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;
    private String date;
    private Integer invoiceNumber;
    private String customerName;
    private String billingAddress;
    private String gstin;
    private BigDecimal totalAmount;

    @OneToMany(mappedBy = "invoiceHeader")
    private List<InvoiceItem> invoiceItemList ;

    @OneToMany(mappedBy = "invoiceHeader")
    private List<InvoiceBillSundry> invoiceBillSundryList;
}
