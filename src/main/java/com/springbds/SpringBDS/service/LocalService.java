package com.springbds.SpringBDS.service;

import com.springbds.SpringBDS.entity.Local;
import com.springbds.SpringBDS.entity.Manager;

import java.util.List;
import java.util.Optional;

public interface LocalService {

    List<Local> findAllLocals();
    Optional<Local> findLocalByName(String name);
    Optional<Local> findLocalByNameIgnoreCase(String name);
    Local saveLocal(Local local);
    Local updateLocal(Long id, Local local);
    Local updateLocalsManager(Long id, Manager manager);
    void deleteLocal(Long id);

}
