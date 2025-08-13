package com.springbds.SpringBDS.service;

import com.springbds.SpringBDS.entity.Local;

import java.util.List;
import java.util.Optional;

public interface LocalService {

    List<Local> findAllLocals();
    // Optional<Local> findLocalByNameWithJPQL(String name);
    Optional<Local> findLocalByName(String name);
    Optional<Local> findLocalByNameIgnoreCase(String name);
    Local saveLocal(Local local);
    Local updateLocal(Long id, Local local);
    void deleteLocal(Long id);

}
