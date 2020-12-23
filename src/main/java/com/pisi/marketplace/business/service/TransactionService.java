package com.pisi.marketplace.business.service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.jboss.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pisi.marketplace.data.entity.Cart;
import com.pisi.marketplace.data.entity.Member;
import com.pisi.marketplace.data.entity.Product;
import com.pisi.marketplace.data.entity.Transaction;
import com.pisi.marketplace.data.entity.repository.TransactionRepository;
import com.pisi.marketplace.resource.model.CartResource;

@Service
public class TransactionService {
	private static final Logger LOG = Logger.getLogger(TransactionService.class);

	@Autowired
	private TransactionRepository transactionRepository;

	public List<Integer> insertTransaction(List<CartResource> cartList) {
		try {
			List<Integer> idsList = new ArrayList<Integer>();
			List<Transaction> transactionList = conversor(cartList);
			int i;
			for(i=0;i<transactionList.size();i++) {
				var transaction = transactionRepository.saveAndFlush(transactionList.get(i));
				idsList.add((int)transaction.getTransactionId());
			}
			
			return idsList;
		} catch (Exception e) {
			LOG.error("Erro ao cadastrar: " + e.getMessage(), e);
			return null;
		}
	}

	public List<Transaction> findTransactionsByMemberId(long id){
		List<Transaction> transacList = transactionRepository.findAll();
		ArrayList<Transaction> transacResult = new ArrayList<Transaction>();
		for (Transaction t : transacList) {
			Member descriptionTransac = t.getMemberId();
			if (descriptionTransac.getMemberId() == id) {
				transacResult.add(t);
			}
		}
		return transacResult;
	}
	
	public boolean removeTransaction(long id) {
		try {
			transactionRepository.deleteById(id);
			return true;
		} catch (Exception e) {
			LOG.error("Erro ao cadastrar: " + e.getMessage(), e);
			return false;
		}
	}

	public Optional<Transaction> findTransactionsById(long id) {
		Optional<Transaction> transactionFoundById = transactionRepository.findById(id);
		return transactionFoundById;
	}
	
	public List<Transaction> findAllTransactions(){
		List<Transaction> listTransactions = transactionRepository.findAll();
		return listTransactions;
	}

	public List<Transaction> conversor(List<CartResource> cartList) throws Exception {
		try {
			int i;
			Transaction transaction;
			ArrayList<Transaction> transactionList = new ArrayList<Transaction>();
			for(i = 0; i<cartList.size();i++) {
				transaction = new Transaction();
				transaction.setMemberId(cartList.get(i).getMemberID());
				transaction.setProductId(cartList.get(i).getProductID());
				transaction.setQuantity(cartList.get(i).getQuantity());
				transaction.setDate(LocalDateTime.now().toString());
				transactionList.add(transaction);
			}
			
			return transactionList;
		} catch (Exception e) {
			throw new Exception("erro: " + cartList);
		}
	}

}
