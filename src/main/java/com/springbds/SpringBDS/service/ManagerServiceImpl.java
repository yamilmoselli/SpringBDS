package com.springbds.SpringBDS.service;

import com.springbds.SpringBDS.entity.Manager;
import com.springbds.SpringBDS.repository.ManagerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ManagerServiceImpl implements ManagerService {

    @Autowired
    private ManagerRepository managerRepository;

    public List<Manager> findAllManagers() {
        return managerRepository.findAll();
    }

    public Manager saveManager(Manager manager) {
        return managerRepository.save(manager);
    }

    @Override
    public Manager updateManager(Long id, Manager manager) {
        Manager managerDb = managerRepository.findById(id).orElseThrow(() -> new RuntimeException("Manager not found"));
        managerDb.setFirstName(manager.getFirstName());
        managerDb.setLastName(manager.getLastName());
        managerDb.setDni(manager.getDni());
        return managerRepository.save(managerDb);
    }

}
