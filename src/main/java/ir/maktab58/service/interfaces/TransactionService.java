package ir.maktab58.service.interfaces;

import ir.maktab58.data.entities.Transaction;

/**
 * @author Taban Soleymani
 */
public interface TransactionService {
    Transaction saveNewTransaction(Transaction transaction);
}
