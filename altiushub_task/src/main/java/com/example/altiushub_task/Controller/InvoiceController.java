package com.example.altiushub_task.Controller;

import com.example.altiushub_task.Model.InvoiceHeader;
import com.example.altiushub_task.Service.InvoiceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/invoices")
public class InvoiceController {

    private InvoiceService invoiceService;
    @Autowired
    public InvoiceController(InvoiceService invoiceService){
        this.invoiceService =invoiceService;
    }

    @PostMapping("/create")
    public ResponseEntity<InvoiceHeader> createInvoice(@RequestBody InvoiceHeader invoiceHeader) {
        invoiceHeader.setInvoiceNumber(null);
        InvoiceHeader createdInvoice = invoiceService.createOrUpdate(invoiceHeader);
        return ResponseEntity.ok(createdInvoice);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<InvoiceHeader> updateInvoice(@PathVariable UUID id,@RequestBody InvoiceHeader invoiceHeader) {
        invoiceHeader.setId(id);
        InvoiceHeader createdInvoice = invoiceService.createOrUpdate(invoiceHeader);
        return ResponseEntity.ok(createdInvoice);
    }
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteInvoice(@PathVariable Integer id){
        invoiceService.deleteInvoice(id);
        return ResponseEntity.ok().body("Invoice Deleted Succesfully");
    }
    @GetMapping("/findInvoice/{id}")
    public ResponseEntity<InvoiceHeader> findInvoice(@PathVariable Integer id){
        InvoiceHeader invoice = invoiceService.getInvoice(id);
        return ResponseEntity.ok(invoice);
    }

    @GetMapping("/findALlInvoice")
    public ResponseEntity<List<InvoiceHeader>> findInvoice(){
        List<InvoiceHeader> invoices = invoiceService.listInvoice();
        return ResponseEntity.ok(invoices);
    }

}
