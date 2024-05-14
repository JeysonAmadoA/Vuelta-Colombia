package com.uptc.frmw.Services;

import com.uptc.frmw.Entities.Edition;
import com.uptc.frmw.Entities.Participant;
import com.uptc.frmw.Entities.Sponsor;
import com.uptc.frmw.Entities.Team;
import com.uptc.frmw.Repositories.ParticipantRepository;
import com.uptc.frmw.Repositories.TeamHistoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ParticipantService {

    @Autowired
    private ParticipantRepository participantRepository;

    @Autowired
    private EditionService editionService;

    @Autowired
    private SponsorService sponsorService;

    @Autowired
    private TeamService teamService;

    public List<Participant> findAll(){
        return participantRepository.findAll();
    }


    public Participant findById(Long id){
        Optional<Participant> participant = participantRepository.findById(id);
        return participant.orElse(null);
    }

    public List<Participant> findParticipantByEditionId(short idEdition){
        return participantRepository.findByEditionAnio(idEdition);
    }

    public List<Participant> findParticipantBySponsorId(String idSponsor){
        return participantRepository.findBySponsorNit(idSponsor);
    }

    public List<Participant> findParticipantByTeamId(long idTeam){
        return participantRepository.findByIdTeam(idTeam);
    }

    public Participant saveParticipant(Participant participant) {
        Edition edition = editionService.findById(participant.getIdEdition());
        Sponsor sponsor = sponsorService.findById(participant.getIdSponsor());
        Team team = teamService.findById(participant.getIdTeam());
        participant.setEdition(edition);
        participant.setSponsor(sponsor);
        participant.setTeam(team);
        return participantRepository.save(participant);
    }

    public void deleteById(long idParticipant) {
        participantRepository.deleteById(idParticipant);
    }

    public Participant updateParticipant (long id, Participant participant){
        Participant participantBd = findById(id);
        if (participantBd != null) {
            participantBd.setIdEdition(participant.getIdEdition());
            participantBd.setIdSponsor(participant.getIdSponsor());
            participantBd.setIdTeam(participant.getIdTeam());
            return saveParticipant(participantBd);
        }
        throw new RuntimeException("Participante no encontrado");
    }
}
