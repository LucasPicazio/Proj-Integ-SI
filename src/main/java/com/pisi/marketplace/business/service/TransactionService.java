package com.pisi.marketplace.business.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.jboss.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pisi.marketplace.data.entity.Cart;
import com.pisi.marketplace.data.entity.Member;
import com.pisi.marketplace.data.entity.Transaction;
import com.pisi.marketplace.data.entity.repository.TransactionRepository;

@Service
public class TransactionService {
	private static final Logger LOG = Logger.getLogger(TransactionService.class);

	@Autowired
	private TransactionRepository transactionRepository;

	public Member insertTransaction(List<Cart> cartList) {
		try {
			List<Transaction> transactionList = conversor(cartList);
			int i;
			for(i=0;i<transactionList.size();i++) {
				transactionRepository.saveAndFlush(transactionList.get(i));
				
			}
			
			return transactionList.get(0).getMemberId();
		} catch (Exception e) {
			LOG.error("Erro ao cadastrar: " + e.getMessage(), e);
			return null;
		}
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

	public List<Transaction> conversor(List<Cart> cartList) throws Exception {
		try {
			int i;
			Transaction transaction = new Transaction();
			ArrayList<Transaction> transactionList = new ArrayList<Transaction>();
			for(i = 0; i<cartList.size();i++) {
				transaction.setMemberId(cartList.get(i).getMemberId());
				transaction.setProductId(cartList.get(i).getProductId());
				transaction.setQuantity(cartList.get(i).getQuantity());
				transactionList.add(transaction);
			}
			
			return transactionList;
		} catch (Exception e) {
			throw new Exception("erro: " + cartList);
		}
	}

}
