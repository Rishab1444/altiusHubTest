package com.example.altiushub_task.Service;

import com.example.altiushub_task.Model.InvoiceBillSundry;
import com.example.altiushub_task.Model.InvoiceHeader;
import com.example.altiushub_task.Repository.InvoiceHeaderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.List;
import java.util.UUID;

@Service
public class InvoiceService {

    private InvoiceHeaderRepository invoiceHeaderRepository;
    @Autowired
    public InvoiceService(InvoiceHeaderRepository invoiceHeaderRepository){
        this.invoiceHeaderRepository = invoiceHeaderRepository;
    }

    @Transactional
    public InvoiceHeader createOrUpdate(InvoiceHeader invoiceHeader){
        validateInvoiceItem(invoiceHeader);
        return  invoiceHeaderRepository.save(invoiceHeader);
    }

    public void deleteInvoice(Integer id){
        InvoiceHeader invoiceHeader = invoiceHeaderRepository.findByInvoiceNumber(id).orElseThrow(() -> new IllegalArgumentException("Invoice not found with this id"));
        invoiceHeaderRepository.deleteById(invoiceHeader.getId());
    }

    public InvoiceHeader getInvoice(Integer id){
        return invoiceHeaderRepository.findByInvoiceNumber(id)
                .orElseThrow(() -> new IllegalArgumentException("Invoice Not found with id :" +id));
    }
    public List<InvoiceHeader> listInvoice(){
        return invoiceHeaderRepository.findAll();
    }


    private void validateInvoiceItem(InvoiceHeader header){
        BigDecimal itemTotal = header.getInvoiceItemList().stream()
                .map(invoiceItem -> {
                    BigDecimal itemAmount  =invoiceItem.getPrice().multiply(invoiceItem.getQuantity());
                    if (itemAmount.compareTo(invoiceItem.getAmount())!=0){
                        throw new IllegalArgumentException("Item amount does not match quantity time price");
                    }

                    return  itemAmount;
                }).reduce(BigDecimal.ZERO,BigDecimal::add);

        BigDecimal sundriesTotal = header.getInvoiceBillSundryList().stream()
                .map(InvoiceBillSundry::getAmount)
                .reduce(BigDecimal.ZERO,BigDecimal::add);
        BigDecimal totalAmount = itemTotal.add(sundriesTotal);
        if(totalAmount.compareTo(header.getTotalAmount())!=0){
            throw new IllegalArgumentException("Total amount does not match the sum of item and bill sundries");
        }
    }
}
