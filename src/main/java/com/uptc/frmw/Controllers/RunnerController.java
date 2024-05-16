package com.uptc.frmw.Controllers;

import com.uptc.frmw.Entities.Runner;
import com.uptc.frmw.Services.RunnerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

import static com.uptc.frmw.Utilities.Constants.RUNNER;

@RestController
@RequestMapping("/runner")
public class RunnerController extends BaseController {

    @Autowired
    private RunnerService runnerService;

    @GetMapping
    public ResponseEntity<Map<String, Object>> getAll(){
        Map<String, Object> response = getFindResponse(RUNNER, runnerService.findAll());
        return ResponseEntity.ok(response);
    }

    @GetMapping("/{idRunner}")
    public ResponseEntity<Map<String, Object>> getById(@PathVariable long idRunner){
        Map<String, Object> response = getFindResponse(RUNNER, runnerService.findById(idRunner), idRunner);
        return ResponseEntity.ok(response);
    }

    @PostMapping
    public ResponseEntity<Map<String, Object>> saveRunner(@RequestBody Runner runner){
        Map<String, Object> response = getSaveResponse(RUNNER, runnerService.saveRunner(runner));
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    @DeleteMapping("/{idRunner}")
    public ResponseEntity<Map<String, Object>> deleteById(@PathVariable long idRunner){
        runnerService.deleteById(idRunner);
        Map<String, Object> response = getDeleteResponse(RUNNER, idRunner);
        return ResponseEntity.ok(response);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Map<String, Object>> updateRunner(@PathVariable long id, @RequestBody Runner runner){
        Map<String, Object> response = getUpdateResponse(RUNNER, runnerService.updateRunner(id, runner), id);
        return ResponseEntity.ok(response);
    }
}
