package com.uptc.frmw.Controllers;

import com.uptc.frmw.Entities.Sponsor;
import com.uptc.frmw.Services.SponsorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

import static com.uptc.frmw.Utilities.Constants.SPONSOR;

@RestController
@RequestMapping("/sponsor")
public class SponsorController extends BaseController {

    @Autowired
    private SponsorService sponsorService;

    @GetMapping
    public ResponseEntity<Map<String, Object>> getAll(){
        Map<String, Object> response = getFindResponse(SPONSOR, sponsorService.findAll());
        return ResponseEntity.ok(response);
    }

    @GetMapping("/{idSponsor}")
    public ResponseEntity<Map<String, Object>> getById(@PathVariable String idSponsor){
        Map<String, Object> response = getFindResponse(SPONSOR, sponsorService.findById(idSponsor), idSponsor);
        return ResponseEntity.ok(response);
    }

    @PostMapping
    public ResponseEntity<Map<String, Object>> saveSponsor(@RequestBody Sponsor sponsor){
        Map<String, Object> response = getSaveResponse(SPONSOR, sponsorService.saveSponsor(sponsor));
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    @DeleteMapping("/{idSponsor}")
    public ResponseEntity<Map<String, Object>> deleteById(@PathVariable String idSponsor){
        sponsorService.deleteById(idSponsor);
        Map<String, Object> response = getDeleteResponse(SPONSOR, idSponsor);
        return ResponseEntity.ok(response);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Map<String, Object>> updateSponsor(@PathVariable String id, @RequestBody Sponsor sponsor){
        Map<String, Object> response = getUpdateResponse(SPONSOR, sponsorService.updateSponsor(id, sponsor), id);
        return ResponseEntity.ok(response);
    }
}
