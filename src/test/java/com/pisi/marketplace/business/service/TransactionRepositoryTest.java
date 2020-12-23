package com.pisi.marketplace.business.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.times;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import com.pisi.marketplace.data.entity.Cart;
import com.pisi.marketplace.data.entity.Member;
import com.pisi.marketplace.data.entity.Product;
import com.pisi.marketplace.data.entity.Transaction;
import com.pisi.marketplace.data.entity.repository.TransactionRepository;
import com.pisi.marketplace.resource.model.CartResource;
import com.pisi.marketplace.resource.model.ProductResource;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
public class TransactionRepositoryTest {

	@MockBean
	private TransactionRepository repository;
	
	@Autowired
	private TransactionService service;
	
	@Test
	public void insertTransaction() {
		List<CartResource> cartList = new ArrayList<CartResource>();
		CartResource cartResource1 = new CartResource();
		CartResource cartResource2 = new CartResource();
		cartList.add(cartResource1);
		cartList.add(cartResource2);
		
		Transaction transaction = new Transaction();
		Mockito.when(repository.saveAndFlush((Transaction) Mockito.any())).thenReturn(transaction);
		
		List<Integer> idSaved= service.insertTransaction(cartList);
		
		Assert.assertEquals(idSaved.size(), cartList.size());
	}
	
	@Test
	public void findTransactionsByMemberId() {
		long memberId = 0;
		List<Transaction> allTransactions = new ArrayList<Transaction>();
		ArrayList<Transaction> transacResult = new ArrayList<Transaction>();
		
		Mockito.when(repository.findAll()).thenReturn(allTransactions);
		
		for (Transaction t : allTransactions) {
			Member auxTransac = t.getMemberId();
			if (auxTransac.getMemberId() == memberId) {
				transacResult.add(t);
			}
		}
		List<Transaction> transacFinded = service.findTransactionsByMemberId(memberId);
		Assert.assertEquals(transacResult, transacFinded);
	}
	/*
	@Test
	public void removeTransaction() {
		Transaction transaction = new Transaction();
		transaction.setTransactionId(10);
		
		Optional<Transaction> optionalTransac = Optional.of(transaction);
		
		Mockito.when(repository.findById(transaction.getTransactionId())).thenReturn(optionalTransac);
		
		service.removeTransaction(transaction.getTransactionId());
		
		Mockito.verify(repository, times(1)).delete(transaction);
	}
	*/
	@Test
	public void findTransactionsById() {
		long id = 45;
		Transaction transaction = new Transaction();
		transaction.setTransactionId(id);
		
		Optional<Transaction> transactionToReturn = Optional.of(transaction);
		Mockito.when(repository.findById(id)).thenReturn(transactionToReturn);
		
		Optional<Transaction> transactionReturned = service.findTransactionsById(id);
		Assert.assertEquals(transactionReturned, transactionToReturn);
	}
	
	@Test
	public void findAllTransactions() {
		Transaction transaction1 = new Transaction();
		Transaction transaction2 = new Transaction();
		
		List<Transaction> allTransactions = new ArrayList<Transaction>();
		allTransactions.add(transaction1);
		allTransactions.add(transaction2);
		
		Mockito.when(repository.findAll()).thenReturn(allTransactions);
		
		List<Transaction> transacReturned = service.findAllTransactions();
		
		Assert.assertEquals(transacReturned.size(), allTransactions.size());
	}
	
}
