package com.uptc.frmw.Controllers;

import com.uptc.frmw.Entities.Team;
import com.uptc.frmw.Services.TeamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

import static com.uptc.frmw.Utilities.Constants.TEAM;

@RestController
@RequestMapping("/team")
public class TeamController extends BaseController{

    @Autowired
    private TeamService teamService;

    @GetMapping
    public ResponseEntity<Map<String, Object>> getAll(){
        Map<String, Object> response = getFindResponse(TEAM, teamService.findAll());
        return ResponseEntity.ok(response);
    }

    @GetMapping("/{idTeam}")
    public ResponseEntity<Map<String, Object>> getById(@PathVariable long idTeam){
        Map<String, Object> response = getFindResponse(TEAM, teamService.findById(idTeam), idTeam);
        return ResponseEntity.ok(response);
    }

    @PostMapping
    public ResponseEntity<Map<String, Object>> saveTeam(@RequestBody Team team){
        Map<String, Object> response = getSaveResponse(TEAM, teamService.saveTeam(team));
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    @DeleteMapping("/{idTeam}")
    public ResponseEntity<Map<String, Object>> deleteById(@PathVariable long idTeam){
        teamService.deleteById(idTeam);
        Map<String, Object> response = getDeleteResponse(TEAM, idTeam);
        return ResponseEntity.ok(response);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Map<String, Object>> updateTeam(@PathVariable long id, @RequestBody Team team){
        Map<String, Object> response = getUpdateResponse(TEAM, teamService.updateTeam(id, team), id);
        return ResponseEntity.ok(response);
    }
}
