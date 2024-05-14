package com.uptc.frmw.Controllers;

import com.uptc.frmw.Entities.Participant;
import com.uptc.frmw.Services.ParticipantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/participant")
public class ParticipantController {

    @Autowired
    private ParticipantService participantService;

    @GetMapping
    public List<Participant> getAll(){
        return participantService.findAll();
    }

    @GetMapping("/{idParticipant}")
    public Participant getById(@PathVariable long idParticipant){
        return participantService.findById(idParticipant);
    }

    @GetMapping("/findByEdition")
    public List<Participant> getByEditionId(@RequestParam short editionId){
        return participantService.findParticipantByEditionId(editionId);
    }
    @GetMapping("/findBySponsor")
    public List<Participant> getBySponsorId(@RequestParam String sponsorId){
        return participantService.findParticipantBySponsorId(sponsorId);
    }
    @GetMapping("/findByTeam")
    public List<Participant> getByTeamId(@RequestParam long teamId){
        return participantService.findParticipantByTeamId(teamId);
    }

    @DeleteMapping("/{idParticipant}")
    public void deleteById(@PathVariable long idParticipant){
        participantService.deleteById(idParticipant);
    }

    @PostMapping
    public Participant saveParticipant(@RequestBody Participant participant){
        return participantService.saveParticipant(participant);
    }

    @PutMapping("/{id}")
    public Participant updateParticipant(@PathVariable long id, @RequestBody Participant participant){
        return participantService.updateParticipant(id,participant);
    }
}
