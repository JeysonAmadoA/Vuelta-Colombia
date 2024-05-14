package com.uptc.frmw.Controllers;

import com.uptc.frmw.Entities.Team;
import com.uptc.frmw.Services.TeamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/team")
public class TeamController {

    @Autowired
    private TeamService teamService;

    @GetMapping
    public List<Team> getAll(){
        return teamService.findAll();
    }

    @GetMapping("/{idTeam}")
    public Team getById(@PathVariable long idTeam){
        return teamService.findById(idTeam);
    }

    @PostMapping
    public Team saveTeam(@RequestBody Team team){
        return teamService.saveTeam(team);
    }

    @DeleteMapping("/{idTeam}")
    public void deleteById(@PathVariable long idTeam){
        teamService.deleteById(idTeam);
    }

    @PutMapping("/{id}")
    public Team updateTeam(@PathVariable long id, @RequestBody Team team){
        return teamService.updateTeam(id, team);
    }
}
