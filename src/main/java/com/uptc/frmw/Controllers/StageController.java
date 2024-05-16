package com.uptc.frmw.Controllers;

import com.uptc.frmw.Entities.Stage;
import com.uptc.frmw.Services.StageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

import static com.uptc.frmw.Utilities.Constants.RUNNER;
import static com.uptc.frmw.Utilities.Constants.STAGE;

@RestController
@RequestMapping("/stage")
public class StageController extends BaseController{

    @Autowired
    private StageService stageService;

    @GetMapping
    public ResponseEntity<Map<String, Object>> getAll(){
        Map<String, Object> response = getFindResponse(STAGE, stageService.findAll());
        return ResponseEntity.ok(response);
    }

    @GetMapping("/{idStage}")
    public ResponseEntity<Map<String, Object>> getById(@PathVariable long idStage){
        Map<String, Object> response = getFindResponse(STAGE, stageService.findById(idStage), idStage);
        return ResponseEntity.ok(response);
    }

    @GetMapping("/find")
    public ResponseEntity<Map<String, Object>> getByEditionId(@RequestParam short editionId){
        Map<String, Object> response = getFindResponse(STAGE, stageService.findStageByEditionId(editionId));
        return ResponseEntity.ok(response);
    }

    @DeleteMapping("/{idStage}")
    public ResponseEntity<Map<String, Object>> deleteById(@PathVariable long idStage){
        stageService.deleteById(idStage);
        Map<String, Object> response = getDeleteResponse(STAGE, idStage);
        return ResponseEntity.ok(response);
    }

    @PostMapping
    public ResponseEntity<Map<String, Object>> saveStage(@RequestBody Stage stage){
        Map<String, Object> response = getSaveResponse(STAGE, stageService.saveStage(stage));
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Map<String, Object>> updateStage(@PathVariable long id, @RequestBody Stage stage){
        Map<String, Object> response = getUpdateResponse(STAGE, stageService.updateStage(id,stage), id);
        return ResponseEntity.ok(response);
    }
}
