package ir.maktab58.service;

import ir.maktab58.data.models.users.Manager;
import org.springframework.stereotype.Service;

/**
 * @author Taban Soleymani
 */
public interface ManagerService {
    Manager saveNewManager(Manager manager);
}
