package com.uptc.frmw.Repositories;

import com.uptc.frmw.Entities.Sponsor;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SponsorRepository extends JpaRepository<Sponsor, String> {
}
