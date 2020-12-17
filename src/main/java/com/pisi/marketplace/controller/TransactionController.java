package com.pisi.marketplace.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pisi.marketplace.business.service.TransactionService;
import com.pisi.marketplace.data.entity.Transaction;
import com.pisi.marketplace.exception.NotFoundException;
import com.pisi.marketplace.resource.model.TransactionResource;

@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
@RequestMapping("api/transaction")
public class TransactionController {
	@Autowired
    private TransactionService transactionService;

	@PostMapping("insert")
    public int insertTransaction(@RequestBody TransactionResource transaction) {
    	return transactionService.insertTransaction(transaction);
    }
	
	@GetMapping("search/id/{searchID}")
    public Optional<Transaction> findTransactionsById(@PathVariable(name = "searchID", required = true) long searchID)
            throws NotFoundException {
        return transactionService.findTransactionsById(searchID);
    }
	
	@PostMapping("{id}/remove")
	 public boolean removeTransactionsById(@PathVariable(name = "id", required = true) long id)
	            throws NotFoundException {
	        return transactionService.removeTransaction(id);
	    }
	
}
