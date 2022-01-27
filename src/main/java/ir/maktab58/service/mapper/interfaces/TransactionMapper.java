package ir.maktab58.service.mapper.interfaces;

import ir.maktab58.data.entities.Transaction;
import ir.maktab58.dto.TransactionDto;
import org.mapstruct.Mapper;

/**
 * @author Taban Soleymani
 */
@Mapper
public interface TransactionMapper {
    Transaction toTransaction(TransactionDto transactionDto);

    TransactionDto toTransactionDto(Transaction transaction);
}
