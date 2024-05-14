package com.uptc.frmw.Repositories;

import com.uptc.frmw.Entities.Team;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TeamRepository extends JpaRepository<Team, Long> {
}
