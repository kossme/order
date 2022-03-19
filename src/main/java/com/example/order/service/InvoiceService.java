package com.example.order.service;

import com.example.order.model.Invoice;
import com.example.order.repository.InvoiceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class InvoiceService {

    @Autowired
    InvoiceRepository invoiceRepository;

    public Optional<Invoice> getOne(Long id) {
        return invoiceRepository.findById(id);
    }

    public List<Invoice> findAll() {
        return invoiceRepository.findAll();
    }

    public Invoice saveNew(Invoice invoice) {
        Invoice invoiceFromDb = invoiceRepository.save(invoice);
        //logic of send invoice to payment
        return invoice;
    }

    public Invoice update(Invoice invoice) {
        return invoiceRepository.save(invoice);
    }

    public void deleteById(Long id) {
        invoiceRepository.deleteById(id);
    }
}
