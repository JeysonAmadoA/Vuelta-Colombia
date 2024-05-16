package com.uptc.frmw.Services;

import com.uptc.frmw.Entities.Team;
import com.uptc.frmw.Repositories.TeamRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TeamService {

    @Autowired
    private TeamRepository teamRepository;

    public List<Team> findAll(){
        return teamRepository.findAll();
    }

    public Team findById(long id){
        Optional<Team> team = teamRepository.findById(id);
        return team.orElse(null);
    }

    public Team saveTeam(Team team) {
        return teamRepository.save(team);
    }

    public void deleteById(long idTeam) {
        teamRepository.deleteById(idTeam);
    }

    public Team updateTeam (long id, Team team){
        Team teamBd = findById(id);
        if (teamBd != null) {
            teamBd.setNameTeam(team.getNameTeam());
            teamBd.setDateFundation(team.getDateFundation());
            return saveTeam(teamBd);
        }
        throw new RuntimeException("Equipo no encontrado");
    }
}
