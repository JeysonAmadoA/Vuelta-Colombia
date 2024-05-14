package com.uptc.frmw.Controllers;

import com.uptc.frmw.Entities.Stage;
import com.uptc.frmw.Services.StageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/stage")
public class StageController {

    @Autowired
    private StageService stageService;

    @GetMapping
    public List<Stage> getAll(){
        return stageService.findAll();
    }

    @GetMapping("/{idStage}")
    public Stage getById(@PathVariable long idStage){
        return stageService.findById(idStage);
    }

    @GetMapping("/find")
    public List<Stage> getByEditionId(@RequestParam short editionId){
        return stageService.findStageByEditionId(editionId);
    }

    @DeleteMapping("/{idStage}")
    public void deleteById(@PathVariable long idStage){
        stageService.deleteById(idStage);
    }

    @PostMapping
    public Stage saveStage(@RequestBody Stage stage){
        return stageService.saveStage(stage);
    }

    @PutMapping("/{id}")
    public Stage updateStage(@PathVariable long id, @RequestBody Stage stage){
        return stageService.updateStage(id,stage);
    }
}
