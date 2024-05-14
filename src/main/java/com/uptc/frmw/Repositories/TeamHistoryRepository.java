package com.uptc.frmw.Repositories;

import com.uptc.frmw.Entities.Stage;
import com.uptc.frmw.Entities.TeamHistory;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TeamHistoryRepository extends JpaRepository<TeamHistory, Long> {

    public List<TeamHistory> findByIdTeam(long idTeam);
    public List<TeamHistory> findByIdRunner(long idRunner);
    public List<TeamHistory> findByIdEdition(short idEdition);
}
