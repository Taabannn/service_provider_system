package ir.maktab58.service.mapper.Impl;

import ir.maktab58.data.entities.Transaction;
import ir.maktab58.dto.TransactionDto;
import ir.maktab58.service.mapper.interfaces.TransactionMapper;
import org.springframework.stereotype.Component;

/**
 * @author Taban Soleymani
 */
@Component
public class TransactionMapperImpl implements TransactionMapper {
    @Override
    public Transaction toTransaction(TransactionDto transactionDto) {
        return null;
    }

    @Override
    public TransactionDto toTransactionDto(Transaction transaction) {
        return null;
    }
}
