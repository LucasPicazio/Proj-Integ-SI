package com.pisi.marketplace.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import com.pisi.marketplace.business.service.TransactionService;
import com.pisi.marketplace.data.entity.Cart;
import com.pisi.marketplace.data.entity.Transaction;
import com.pisi.marketplace.exception.NotFoundException;
import com.pisi.marketplace.resource.model.CartResource;

@RunWith(SpringRunner.class)
@SpringBootTest(classes=TransactionController.class)
public class TransactionControllerTest {
	@MockBean
    private TransactionService service;
	
	@Autowired
	private TransactionController controller;
	
	@Test
	public void insertTransaction() {
		List<CartResource> cartListToInsert = new ArrayList<CartResource>();
		cartListToInsert.add(new CartResource());
		cartListToInsert.add(new CartResource());
		
		List<Integer> idsInserted = new ArrayList<Integer>();
		idsInserted.add(1);
		idsInserted.add(2);
		
		Mockito.when(service.insertTransaction(cartListToInsert)).thenReturn(idsInserted);
		List<Integer> idsReturned = controller.insertTransaction(cartListToInsert);
		
		Assert.assertEquals(idsReturned.size(), idsInserted.size());
	}
	
	@Test
	public void findTransactionsByMemberId() throws NotFoundException {
		int memberIdToFind = 10;
		List<Transaction> transacToReturn = new ArrayList<Transaction>();
		Mockito.when(service.findTransactionsByMemberId(memberIdToFind)).thenReturn(transacToReturn);
		
		List<Transaction> transacReturned = controller.findTransactionsByMemberId(memberIdToFind);
		
		Assert.assertEquals(transacToReturn, transacReturned);
	}
	
	@Test
	public void findTransactionsById() throws NotFoundException {
		int idToFind = 10;
		Optional<Transaction> transacToReturn = Optional.empty();
		Mockito.when(service.findTransactionsById(idToFind)).thenReturn(transacToReturn);
		
		Optional<Transaction> transacReturned = controller.findTransactionsById(idToFind);
		
		Assert.assertEquals(transacToReturn, transacReturned);
	}
	
	@Test
	public void removeTransactionsById() throws NotFoundException {
		boolean removed = true;
		int idToRemove = 10;
		Mockito.when(service.removeTransaction(idToRemove)).thenReturn(removed);
		boolean transactionRemoved = controller.removeTransactionsById(idToRemove);
		Assert.assertEquals(removed, transactionRemoved);
	}
	
}
