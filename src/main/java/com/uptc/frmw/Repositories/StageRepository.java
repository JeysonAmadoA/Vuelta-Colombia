package com.uptc.frmw.Repositories;

import com.uptc.frmw.Entities.Stage;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface StageRepository extends JpaRepository<Stage, Long> {

    public List<Stage> findByIdEdition(short idEdition);
}
