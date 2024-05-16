package com.uptc.frmw.Controllers;


import com.uptc.frmw.Entities.Podium;
import com.uptc.frmw.Services.PodiumService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

import static com.uptc.frmw.Utilities.Constants.PODIUM;

@RestController
@RequestMapping("/podium")
public class PodiumController extends BaseController {

    @Autowired
    private PodiumService podiumService;

    @GetMapping
    public ResponseEntity<Map<String, Object>> getAll(){
        Map<String, Object> response = getFindResponse(PODIUM, podiumService.findAll());
        return ResponseEntity.ok(response);
    }

    @GetMapping("/{idPodium}")
    public ResponseEntity<Map<String, Object>> getById(@PathVariable long idPodium){
        Map<String, Object> response = getFindResponse(PODIUM, podiumService.findById(idPodium), idPodium);
        return ResponseEntity.ok(response);
    }

    @GetMapping("/findByRunner")
    public ResponseEntity<Map<String, Object>> getByRunnerId(@RequestParam long runnerId){
        Map<String, Object> response = getFindResponse(PODIUM, podiumService.findPodiumByRunnerId(runnerId));
        return ResponseEntity.ok(response);
    }

    @GetMapping("/findByStage")
    public ResponseEntity<Map<String, Object>> getByStageId(@RequestParam long stageId){
        Map<String, Object> response = getFindResponse(PODIUM, podiumService.findPodiumByStageId(stageId));
        return ResponseEntity.ok(response);
    }

    @DeleteMapping("/{idPodium}")
    public ResponseEntity<Map<String, Object>> deleteById(@PathVariable long idPodium){
        podiumService.deleteById(idPodium);
        Map<String, Object> response = getDeleteResponse(PODIUM, idPodium);
        return ResponseEntity.ok(response);
    }

    @PostMapping
    public ResponseEntity<Map<String, Object>> savePodium(@RequestBody Podium podium){
        Map<String, Object> response = getSaveResponse(PODIUM, podiumService.savePodium(podium));
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Map<String, Object>> updatePodium(@PathVariable long id, @RequestBody Podium podium){
        Map<String, Object> response = getUpdateResponse(PODIUM, podiumService.updatePodium(id,podium), id);
        return ResponseEntity.ok(response);
    }
}
