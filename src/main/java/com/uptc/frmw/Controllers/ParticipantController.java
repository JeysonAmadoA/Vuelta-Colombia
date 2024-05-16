package com.uptc.frmw.Controllers;

import com.uptc.frmw.Entities.Participant;
import com.uptc.frmw.Services.ParticipantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

import static com.uptc.frmw.Utilities.Constants.PARTICIPANT;

@RestController
@RequestMapping("/participant")
public class ParticipantController extends BaseController {

    @Autowired
    private ParticipantService participantService;

    @GetMapping
    public ResponseEntity<Map<String, Object>> getAll(){
        Map<String, Object> response = getFindResponse(PARTICIPANT, participantService.findAll());
        return ResponseEntity.ok(response);
    }

    @GetMapping("/{idParticipant}")
    public ResponseEntity<Map<String, Object>> getById(@PathVariable long idParticipant){
        Map<String, Object> response = getFindResponse(PARTICIPANT, participantService.findById(idParticipant), idParticipant);
        return ResponseEntity.ok(response);
    }

    @GetMapping("/findByEdition")
    public ResponseEntity<Map<String, Object>> getByEditionId(@RequestParam short editionId){
        Map<String, Object> response = getFindResponse(PARTICIPANT, participantService.findParticipantByEditionId(editionId));
        return ResponseEntity.ok(response);
    }
    @GetMapping("/findBySponsor")
    public ResponseEntity<Map<String, Object>> getBySponsorId(@RequestParam String sponsorId){
        Map<String, Object> response = getFindResponse(PARTICIPANT, participantService.findParticipantBySponsorId(sponsorId));
        return ResponseEntity.ok(response);
    }
    @GetMapping("/findByTeam")
    public ResponseEntity<Map<String, Object>> getByTeamId(@RequestParam long teamId){
        Map<String, Object> response = getFindResponse(PARTICIPANT, participantService.findParticipantByTeamId(teamId));
        return ResponseEntity.ok(response);
    }

    @DeleteMapping("/{idParticipant}")
    public ResponseEntity<Map<String, Object>> deleteById(@PathVariable long idParticipant){
        participantService.deleteById(idParticipant);
        Map<String, Object> response = getDeleteResponse(PARTICIPANT, idParticipant);
        return ResponseEntity.ok(response);
    }

    @PostMapping
    public ResponseEntity<Map<String, Object>> saveParticipant(@RequestBody Participant participant){
        Map<String, Object> response = getSaveResponse(PARTICIPANT, participantService.saveParticipant(participant));
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Map<String, Object>> updateParticipant(@PathVariable long id, @RequestBody Participant participant){
        Map<String, Object> response = getUpdateResponse(PARTICIPANT, participantService.updateParticipant(id, participant), id);
        return ResponseEntity.ok(response);
    }
}
