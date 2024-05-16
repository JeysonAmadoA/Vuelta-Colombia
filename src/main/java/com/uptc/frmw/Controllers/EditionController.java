package com.uptc.frmw.Controllers;

import com.uptc.frmw.Entities.Edition;
import com.uptc.frmw.Services.EditionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import static com.uptc.frmw.Utilities.Constants.EDITION;

import java.util.Map;

@RestController
@RequestMapping("/edition")
public class EditionController extends BaseController {

    @Autowired
    private EditionService editionService;

    @GetMapping
    public ResponseEntity<Map<String, Object>> getAll(){
        Map<String, Object> response = getFindResponse(EDITION, editionService.findAll());
        return ResponseEntity.ok(response);
    }

    @GetMapping("/{idEdition}")
    public ResponseEntity<Map<String, Object>> getById(@PathVariable short idEdition){
        Map<String, Object> response = getFindResponse(EDITION, editionService.findById(idEdition), idEdition);
        return ResponseEntity.ok(response);
    }

    @PostMapping
    public ResponseEntity<Map<String, Object>> saveEdition(@RequestBody Edition edition){
        Map<String, Object> response = getSaveResponse(EDITION, editionService.saveEdition(edition));
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    @DeleteMapping("/{idEdition}")
    public ResponseEntity<Map<String, Object>> deleteById(@PathVariable short idEdition){
        editionService.deleteById(idEdition);
        Map<String, Object> response = getDeleteResponse(EDITION, idEdition);
        return ResponseEntity.ok().body(response);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Map<String, Object>> updateEdition(@PathVariable short id, @RequestBody Edition edition){
        Map<String, Object> response = getUpdateResponse(EDITION, editionService.updateEdition(id, edition), id);
        return ResponseEntity.ok().body(response);
    }
}
