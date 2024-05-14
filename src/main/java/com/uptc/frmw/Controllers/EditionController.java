package com.uptc.frmw.Controllers;

import com.uptc.frmw.Entities.Edition;
import com.uptc.frmw.Services.EditionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/edition")
public class EditionController {

    @Autowired
    private EditionService editionService;

    @GetMapping
    public List<Edition> getAll(){
        return editionService.findAll();
    }

    @GetMapping("/{idEdition}")
    public Edition getById(@PathVariable short idEdition){
        return editionService.findById(idEdition);
    }

    @PostMapping
    public Edition saveEdition(@RequestBody Edition edition){
        return editionService.saveEdition(edition);
    }

    @DeleteMapping("/{idEdition}")
    public void deleteById(@PathVariable short idEdition){
        editionService.deleteById(idEdition);
    }

    @PutMapping("/{id}")
    public Edition updateEdition(@PathVariable short id, @RequestBody Edition edition){
        return editionService.updateEdition(id, edition);
    }
}
