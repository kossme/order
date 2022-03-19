package com.example.order.controller;

import com.example.order.model.Invoice;
import com.example.order.service.InvoiceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/invoice")
public class InvoiceController {

    @Autowired
    InvoiceService invoiceService;

    @GetMapping("/{id}")
    public ResponseEntity<Invoice> getById(@PathVariable Long id) throws Exception {
        var invoice = invoiceService.getOne(id);
        return ResponseEntity.of(invoice);
    }

    @GetMapping
    public ResponseEntity<List<Invoice>> getAll() throws Exception {
        var invoices = invoiceService.findAll();
        return ResponseEntity.ok(invoices);
    }

    @PostMapping
    public ResponseEntity<Invoice> create(@RequestBody Invoice invoice) throws Exception {
        return ResponseEntity.ok(invoiceService.saveNew(invoice));
    }

    @PutMapping
    public ResponseEntity<Invoice> update(@RequestBody Invoice invoice) throws Exception {
        if (invoice.getId() == null) {
            throw new Exception("Invoice for update must have an ID");
        }
        return ResponseEntity.ok(invoiceService.update(invoice));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Long> delete(@PathVariable Long id) throws Exception {
        invoiceService.deleteById(id);
        return ResponseEntity.ok(id);
    }

}
