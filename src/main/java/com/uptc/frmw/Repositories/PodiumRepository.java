package com.uptc.frmw.Repositories;

import com.uptc.frmw.Entities.Podium;
import com.uptc.frmw.Entities.Stage;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PodiumRepository extends JpaRepository<Podium, Long> {

    public List<Podium> findByIdRunner(long idRunner);
    public List<Podium> findByIdStage(long idStage);
}
