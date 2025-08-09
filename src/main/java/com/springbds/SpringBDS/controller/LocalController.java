package com.springbds.SpringBDS.controller;

import com.springbds.SpringBDS.entity.Local;
import com.springbds.SpringBDS.service.LocalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/locals")
public class LocalController {

    @Autowired
    LocalService localService;

    @GetMapping
    public List<Local> findAllLocals() {
        return localService.findAllLocals();
    }

    @GetMapping("/{id}")
    public Local findLocalById(@PathVariable Long id) {
        return localService.findLocalById(id);
    }

    @PostMapping
    public Local saveLocal(@RequestBody Local local) {
        return localService.saveLocal(local);
    }

    @PutMapping("/{id}")
    public Local updateLocal(@PathVariable Long id, @RequestBody Local local) {
        return localService.updateLocal(id, local);
    }

    @DeleteMapping("/{id}")
    public String deleteLocal(@PathVariable Long id) {
        localService.deleteLocal(id);
        return "Local deleted successfully";
    }

}
