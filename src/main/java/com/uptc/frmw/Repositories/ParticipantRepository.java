package com.uptc.frmw.Repositories;

import com.uptc.frmw.Entities.Participant;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ParticipantRepository extends JpaRepository<Participant, Long> {

    public List<Participant> findByEditionAnio(short idEdition);
    public List<Participant> findBySponsorNit(String idSponsor);
    public List<Participant> findByIdTeam(long idTeam);
}
