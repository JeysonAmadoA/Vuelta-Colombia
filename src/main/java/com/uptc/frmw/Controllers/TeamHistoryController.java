package com.uptc.frmw.Controllers;


import com.uptc.frmw.Entities.TeamHistory;
import com.uptc.frmw.Services.TeamHistoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

import static com.uptc.frmw.Utilities.Constants.TEAM_HISTORY;

@RestController
@RequestMapping("/teamHistory")
public class TeamHistoryController extends BaseController {

    @Autowired
    private TeamHistoryService teamHistoryService;

    @GetMapping
    public ResponseEntity<Map<String, Object>> getAll(){
        Map<String, Object> response = getFindResponse(TEAM_HISTORY, teamHistoryService.findAll());
        return ResponseEntity.ok(response);
    }

    @GetMapping("/{idTeamHistory}")
    public ResponseEntity<Map<String, Object>> getById(@PathVariable long idTeamHistory){
        Map<String, Object> response = getFindResponse(TEAM_HISTORY,
                teamHistoryService.findById(idTeamHistory), idTeamHistory);

        return ResponseEntity.ok(response);
    }

    @GetMapping("/findByTeam")
    public ResponseEntity<Map<String, Object>> getByTeamId(@RequestParam long teamId){
        Map<String, Object> response = getFindResponse(TEAM_HISTORY,
                teamHistoryService.findTeamHistoryByTeamId(teamId));

        return ResponseEntity.ok(response);
    }

    @GetMapping("/findByRunner")
    public ResponseEntity<Map<String, Object>> getByRunnerId(@RequestParam long runnerId){
        Map<String, Object> response = getFindResponse(TEAM_HISTORY,
                teamHistoryService.findTeamHistoryByRunnerId(runnerId));

        return ResponseEntity.ok(response);
    }

    @GetMapping("/findByEdition")
    public ResponseEntity<Map<String, Object>> getByEditionId(@RequestParam short editionId){
        Map<String, Object> response = getFindResponse(TEAM_HISTORY,
                teamHistoryService.findTeamHistoryByEditionId(editionId));

        return ResponseEntity.ok(response);
    }

    @DeleteMapping("/{idTeamHistory}")
    public ResponseEntity<Map<String, Object>> deleteById(@PathVariable long idTeamHistory){
        teamHistoryService.deleteById(idTeamHistory);
        Map<String, Object> response = getDeleteResponse(TEAM_HISTORY, idTeamHistory);
        return ResponseEntity.ok(response);
    }

    @PostMapping
    public ResponseEntity<Map<String, Object>> saveTeamHistory(@RequestBody TeamHistory teamHistory){
        Map<String, Object> response = getSaveResponse(TEAM_HISTORY, teamHistoryService.saveTeamHistory(teamHistory));
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Map<String, Object>> updateTeamHistory(@PathVariable long id, @RequestBody TeamHistory teamHistory){
        Map<String, Object> response = getUpdateResponse(TEAM_HISTORY,
                teamHistoryService.updateTeamHistory(id, teamHistory), id);

        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }
}
