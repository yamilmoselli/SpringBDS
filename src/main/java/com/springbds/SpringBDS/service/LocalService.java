package com.springbds.SpringBDS.service;

import com.springbds.SpringBDS.entity.Local;

import java.util.List;

public interface LocalService {

    List<Local> findAllLocals();
    Local findLocalById(Long id);
    Local saveLocal(Local local);
    Local updateLocal(Long id, Local local);
    void deleteLocal(Long id);

}
