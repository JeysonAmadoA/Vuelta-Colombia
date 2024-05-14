package com.uptc.frmw.Controllers;


import com.uptc.frmw.Entities.Podium;
import com.uptc.frmw.Services.PodiumService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/podium")
public class PodiumController {

    @Autowired
    private PodiumService podiumService;

    @GetMapping
    public List<Podium> getAll(){
        return podiumService.findAll();
    }

    @GetMapping("/{idPodium}")
    public Podium getById(@PathVariable long idPodium){
        return podiumService.findById(idPodium);
    }

    @GetMapping("/findByRunner")
    public List<Podium> getByRunnerId(@RequestParam long runnerId){
        return podiumService.findPodiumByRunnerId(runnerId);
    }

    @GetMapping("/findByStage")
    public List<Podium> getBySatageId(@RequestParam long stageId){
        return podiumService.findPodiumByStageId(stageId);
    }

    @DeleteMapping("/{idPodium}")
    public void deleteById(@PathVariable long idPodium){
        podiumService.deleteById(idPodium);
    }

    @PostMapping
    public Podium savePodium(@RequestBody Podium podium){
        return podiumService.savePodium(podium);
    }

    @PutMapping("/{id}")
    public Podium updatePodium(@PathVariable long id, @RequestBody Podium podium){
        return podiumService.updatePodium(id,podium);
    }
}
