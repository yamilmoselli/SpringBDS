package com.springbds.SpringBDS.controller;

import com.springbds.SpringBDS.entity.Local;
import com.springbds.SpringBDS.error.LocalNotFoundException;
import com.springbds.SpringBDS.service.LocalService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/locals")
public class LocalController {

    @Autowired
    LocalService localService;

    @GetMapping
    public List<Local> findAllLocals() {
        return localService.findAllLocals();
    }

    /*
    @GetMapping("/{name}")
    public Optional<Local> findLocalByNameWithJPQL(@PathVariable String name) {
        return localService.findLocalByNameWithJPQL(name);
    }
    */

    /*
    @GetMapping("/{name}")
    public Optional<Local> findLocalByName(@PathVariable String name) {
        return localService.findLocalByName(name);
    }
    */

    @GetMapping("/{name}")
    public Local findLocalByNameIgnoreCase(@PathVariable String name) {
        return localService.findLocalByNameIgnoreCase(name)
                .orElseThrow(() -> new LocalNotFoundException("Local named '" + name + "' not found"));
    }

    @PostMapping
    public Local saveLocal(@Valid @RequestBody Local local) {
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
