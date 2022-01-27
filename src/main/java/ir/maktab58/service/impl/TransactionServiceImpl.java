package ir.maktab58.service.impl;

import ir.maktab58.data.entities.Transaction;
import ir.maktab58.data.repository.TransactionRepository;
import ir.maktab58.service.interfaces.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author Taban Soleymani
 */
@Service
public class TransactionServiceImpl implements TransactionService {
    @Autowired
    TransactionRepository transactionRepository;

    @Override
    public Transaction saveNewTransaction(Transaction transaction) {
        return transactionRepository.save(transaction);
    }
}
