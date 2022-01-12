package ir.maktab58.service;

import ir.maktab58.data.dao.ManagerDao;
import ir.maktab58.data.models.users.Manager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author Taban Soleymani
 */
@Service
public class ManagerServiceImpl implements ManagerService {
    @Autowired
    ManagerDao managerDao;

    @Override
    public Manager saveNewManager(Manager manager) {
        return managerDao.save(manager);
    }
}
