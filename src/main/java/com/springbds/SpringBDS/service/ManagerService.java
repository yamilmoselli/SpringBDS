package com.springbds.SpringBDS.service;

import com.springbds.SpringBDS.entity.Manager;

import java.util.List;

public interface ManagerService {

    List<Manager> findAllManagers();
    Manager saveManager(Manager manager);
    Manager updateManager(Long id, Manager manager);

}
