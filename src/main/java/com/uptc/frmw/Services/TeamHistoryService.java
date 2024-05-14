package com.uptc.frmw.Services;

import com.uptc.frmw.Entities.Edition;
import com.uptc.frmw.Entities.Runner;
import com.uptc.frmw.Entities.Team;
import com.uptc.frmw.Entities.TeamHistory;
import com.uptc.frmw.Repositories.TeamHistoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TeamHistoryService {

    @Autowired
    private TeamHistoryRepository teamHistoryRepository;

    @Autowired
    private TeamService teamService;

    @Autowired
    private RunnerService runnerService;

    @Autowired
    private EditionService editionService;

    public List<TeamHistory> findAll(){
        return teamHistoryRepository.findAll();
    }

    public TeamHistory findById(long idTeamHistory) {
        return teamHistoryRepository.findById(idTeamHistory).orElse(null);
    }

    public List<TeamHistory> findTeamHistoryByRunnerId(long idRunner){
        return teamHistoryRepository.findByIdRunner(idRunner);
    }

    public List<TeamHistory> findTeamHistoryByTeamId(long idTeam){
        return teamHistoryRepository.findByIdTeam(idTeam);
    }

    public List<TeamHistory> findTeamHistoryByEditionId(short idEdition){
        return teamHistoryRepository.findByIdEdition(idEdition);
    }

    public void deleteById(long idTeamHistory) {
        teamHistoryRepository.deleteById(idTeamHistory);
    }

    public TeamHistory saveTeamHistory(TeamHistory teamHistory) {
        Runner runner = runnerService.findById(teamHistory.getIdRunner());
        Team team = teamService.findById(teamHistory.getIdTeam());
        Edition edition = editionService.findById(teamHistory.getIdEdition());
        teamHistory.setRunner(runner);
        teamHistory.setTeam(team);
        teamHistory.setEdition(edition);
        return teamHistoryRepository.save(teamHistory);
    }

    public TeamHistory updateTeamHistory (long id, TeamHistory teamHistory){
        TeamHistory teamHistoryBd = findById(id);
        if (teamHistoryBd != null) {
            teamHistoryBd.setIdTeam(teamHistory.getIdTeam());
            teamHistoryBd.setIdRunner(teamHistory.getIdRunner());
            teamHistoryBd.setIdEdition(teamHistory.getIdEdition());
            teamHistoryBd.setDateAdmission(teamHistory.getDateAdmission());
            return saveTeamHistory(teamHistoryBd);
        }
        throw new RuntimeException("Historial de equipo no encontrado");
    }
}
