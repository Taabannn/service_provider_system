package ir.maktab58.data.repository;

import ir.maktab58.data.entities.ImageFile;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author Taban Soleymani
 */
@Transactional
@Repository
public interface ImageFileRepository extends JpaRepository<ImageFile, Integer> {
}
