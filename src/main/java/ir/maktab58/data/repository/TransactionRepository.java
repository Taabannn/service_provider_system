package ir.maktab58.data.repository;

import ir.maktab58.data.entities.Transaction;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.persistence.criteria.CriteriaBuilder;

/**
 * @author Taban Soleymani
 */
@Repository
public interface TransactionRepository extends JpaRepository<Transaction, Integer> {
}
