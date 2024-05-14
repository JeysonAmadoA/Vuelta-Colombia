package com.uptc.frmw.Controllers;

import com.uptc.frmw.Entities.Runner;
import com.uptc.frmw.Services.RunnerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/runner")
public class RunnerController {

    @Autowired
    private RunnerService runnerService;

    @GetMapping
    public List<Runner> getAll(){
        return runnerService.findAll();
    }

    @GetMapping("/{idRunner}")
    public Runner getById(@PathVariable long idRunner){
        return runnerService.findById(idRunner);
    }

    @PostMapping
    public Runner saveRunner(@RequestBody Runner runner){
        return runnerService.saveRunner(runner);
    }

    @DeleteMapping("/{idRunner}")
    public void deleteById(@PathVariable long idRunner){
        runnerService.deleteById(idRunner);
    }

    @PutMapping("/{id}")
    public Runner updateRunner(@PathVariable long id, @RequestBody Runner runner){
        return runnerService.updateRunner(id, runner);
    }
}
