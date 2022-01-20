package ir.maktab58.dto;

import ir.maktab58.data.enums.TransactionStatus;

import java.util.Date;

/**
 * @author Taban Soleymani
 */
public class TransactionDto {
    private OrderDto order;
    private Date creationDate;
    private TransactionStatus transactionStatus;
}
