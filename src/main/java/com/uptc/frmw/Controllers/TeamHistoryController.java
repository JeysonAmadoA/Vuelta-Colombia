package com.uptc.frmw.Controllers;


import com.uptc.frmw.Entities.Stage;
import com.uptc.frmw.Entities.TeamHistory;
import com.uptc.frmw.Services.TeamHistoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/teamHistory")
public class TeamHistoryController {

    @Autowired
    private TeamHistoryService teamHistoryService;

    @GetMapping
    public List<TeamHistory> getAll(){
        return teamHistoryService.findAll();
    }

    @GetMapping("/{idTeamHistory}")
    public TeamHistory getById(@PathVariable long idTeamHistory){
        return teamHistoryService.findById(idTeamHistory);
    }

    @GetMapping("/findByTeam")
    public List<TeamHistory> getByTeamId(@RequestParam long teamId){
        return teamHistoryService.findTeamHistoryByTeamId(teamId);
    }

    @GetMapping("/findByRunner")
    public List<TeamHistory> getByRunnerId(@RequestParam long runnerId){
        return teamHistoryService.findTeamHistoryByRunnerId(runnerId);
    }

    @GetMapping("/findByEdition")
    public List<TeamHistory> getByEditionId(@RequestParam short editionId){
        return teamHistoryService.findTeamHistoryByEditionId(editionId);
    }

    @DeleteMapping("/{idTeamHistory}")
    public void deleteById(@PathVariable long idTeamHistory){
        teamHistoryService.deleteById(idTeamHistory);
    }

    @PostMapping
    public TeamHistory saveTeamHistory(@RequestBody TeamHistory teamHistory){
        return teamHistoryService.saveTeamHistory(teamHistory);
    }

    @PutMapping("/{id}")
    public TeamHistory updateTeamHistory(@PathVariable long id, @RequestBody TeamHistory teamHistory){
        return teamHistoryService.updateTeamHistory(id,teamHistory);
    }
}
