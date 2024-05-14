package com.uptc.frmw.Repositories;

import com.uptc.frmw.Entities.Runner;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RunnerRepository extends JpaRepository<Runner, Long> {
}
