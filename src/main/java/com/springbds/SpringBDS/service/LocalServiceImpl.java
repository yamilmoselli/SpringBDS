package com.springbds.SpringBDS.service;

import com.springbds.SpringBDS.entity.Local;
import com.springbds.SpringBDS.entity.Manager;
import com.springbds.SpringBDS.repository.LocalRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class LocalServiceImpl implements LocalService {

    @Autowired
    LocalRepository localRepository;

    @Override
    public List<Local> findAllLocals() {
        return localRepository.findAll();
    }

    @Override
    public Optional<Local> findLocalByName(String name) {
        return localRepository.findByName(name);
    }

    @Override
    public Optional<Local> findLocalByNameIgnoreCase(String name) {
        return localRepository.findByNameIgnoreCase(name);
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

    public Local updateLocalsManager(Long id, Manager manager) {
        Local localDb = localRepository.findById(id).orElseThrow(() -> new RuntimeException("Local not found"));
        localDb.setManager(manager);
        return localRepository.save(localDb);
    }

    @Override
    public void deleteLocal(Long id) {
        localRepository.deleteById(id);
    }

}
