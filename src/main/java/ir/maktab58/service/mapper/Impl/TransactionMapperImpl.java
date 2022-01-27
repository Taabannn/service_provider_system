package ir.maktab58.service.mapper.Impl;

import ir.maktab58.data.entities.Transaction;
import ir.maktab58.dto.TransactionDto;
import ir.maktab58.service.mapper.interfaces.TransactionMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @author Taban Soleymani
 */
@Component
public class TransactionMapperImpl implements TransactionMapper {
    @Autowired
    private WalletMapperImpl walletMapper;

    @Override
    public Transaction toTransaction(TransactionDto transactionDto) {
        return Transaction.builder()
                .withCost(transactionDto.getCost())
                .withWallet(walletMapper.toWallet(transactionDto.getWalletDto()))
                .withCreationDate(transactionDto.getCreationDate())
                .withTransactionStatus(transactionDto.getTransactionStatus())
                .withTransactionType(transactionDto.getTransactionType())
                .withTrackingCode(transactionDto.getTrackingCode()).build();
    }

    @Override
    public TransactionDto toTransactionDto(Transaction transaction) {
        return TransactionDto.builder()
                .withCost(transaction.getCost())
                .withWalletDto(walletMapper.toWalletDto(transaction.getWallet()))
                .withCreationDate(transaction.getCreationDate())
                .withTransactionStatus(transaction.getTransactionStatus())
                .withTransactionType(transaction.getTransactionType())
                .withTrackingCode(transaction.getTrackingCode()).build();
    }
}
