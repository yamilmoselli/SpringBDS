package com.springbds.SpringBDS.service;

import com.springbds.SpringBDS.entity.Local;
import com.springbds.SpringBDS.repository.LocalRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class LocalServiceImpl implements LocalService {

    @Autowired
    LocalRepository localRepository;

    @Override
    public List<Local> findAllLocals() {
        return localRepository.findAll();
    }

    @Override
    public Local findLocalById(Long id) {
        return localRepository.findById(id).orElseThrow(() -> new RuntimeException("Local not found"));
    }

    @Override
    public Local saveLocal(Local local) {
        return localRepository.save(local);
    }

    @Override
    public Local updateLocal(Long id, Local local) {
        Local localDb = localRepository.findById(id).orElseThrow(() -> new RuntimeException("Local not found"));
        localDb.setName(local.getName());
        localDb.setFloor(local.getFloor());
        localDb.setCode(local.getCode());
        return localRepository.save(localDb);
    }

    @Override
    public void deleteLocal(Long id) {
        localRepository.deleteById(id);
    }

}
