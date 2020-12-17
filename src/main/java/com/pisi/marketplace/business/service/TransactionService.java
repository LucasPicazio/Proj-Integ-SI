package com.pisi.marketplace.business.service;

import java.util.Optional;

import org.jboss.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pisi.marketplace.data.entity.Transaction;
import com.pisi.marketplace.data.entity.repository.TransactionRepository;
import com.pisi.marketplace.resource.model.TransactionResource;

@Service
public class TransactionService {
	private static final Logger LOG = Logger.getLogger(TransactionService.class);

	@Autowired
	private TransactionRepository transactionRepository;

	public int insertTransaction(TransactionResource transactionResource) {
		try {
			Transaction transaction = conversor(transactionResource);
			transactionRepository.saveAndFlush(transaction);
			return (int) transaction.getTransactionId();
		} catch (Exception e) {
			LOG.error("Erro ao cadastrar: " + e.getMessage(), e);
			return -1;
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

	public Transaction conversor(TransactionResource transactionResource) throws Exception {
		try {
			Transaction transaction = new Transaction();
			transaction.setMemberId(transactionResource.getMemberID());
			transaction.setProductId(transactionResource.getProductID());
			transaction.setQuantity(transactionResource.getQuantity());
			return transaction;
		} catch (Exception e) {
			throw new Exception("erro: " + transactionResource);
		}
	}

}
