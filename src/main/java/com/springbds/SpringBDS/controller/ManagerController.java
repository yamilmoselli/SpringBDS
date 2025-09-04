package com.springbds.SpringBDS.controller;

import com.springbds.SpringBDS.entity.Manager;
import com.springbds.SpringBDS.service.ManagerService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/managers")
public class ManagerController {

    @Autowired
    private ManagerService managerService;

    @GetMapping
    public List<Manager> findAllManagers() {
        return managerService.findAllManagers();
    }

    @PostMapping
    public Manager postManager(@Valid @RequestBody Manager manager) {
        return managerService.saveManager(manager);
    }

}
