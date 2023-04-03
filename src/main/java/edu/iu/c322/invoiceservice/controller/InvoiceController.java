package edu.iu.c322.invoiceservice.controller;
import edu.iu.c322.invoiceservice.model.Invoice;
import edu.iu.c322.invoiceservice.model.Invoice;
import edu.iu.c322.invoiceservice.repository.InvoiceRepository;

import java.util.*;

import edu.iu.c322.invoiceservice.repository.InvoiceRepository;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
@RestController
@RequestMapping("/invoices")
public class InvoiceController {
    private InvoiceRepository repository;

    public InvoiceController(InvoiceRepository repository) {
        this.repository = repository;
    }

    @GetMapping("/{id}")
    public Invoice finaInvoiceID(@PathVariable int id){
        return repository.findCustomerID(id);
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    public int create(@Valid @RequestBody Invoice customer){
        return repository.create(customer);
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @PutMapping("/{id}")
    public void update(@Valid @RequestBody Invoice customer, @PathVariable int id){
        repository.update(customer,id);
    }
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping("/{id}")
    public void delete(@PathVariable int id){
        repository.delete(id);
    }

}


