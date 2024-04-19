package com.example.altiushub_task.Repository;

import com.example.altiushub_task.Model.InvoiceHeader;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.UUID;

public interface InvoiceHeaderRepository extends JpaRepository<InvoiceHeader, UUID> {

    Optional<InvoiceHeader> findByInvoiceNumber(Integer invoiceNumber);

}
