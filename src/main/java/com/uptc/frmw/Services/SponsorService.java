package com.uptc.frmw.Services;

import com.uptc.frmw.Entities.Sponsor;
import com.uptc.frmw.Repositories.SponsorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SponsorService {

    @Autowired
    private SponsorRepository sponsorRepository;

    public List<Sponsor> findAll(){
        return sponsorRepository.findAll();
    }

    public Sponsor findById(String id){
        Optional<Sponsor> sponsor = sponsorRepository.findById(id);
        return sponsor.orElse(null);
    }

    public Sponsor saveSponsor(Sponsor sponsor) {
        return sponsorRepository.save(sponsor);
    }

    public void deleteById(String idSponsor) {
        sponsorRepository.deleteById(idSponsor);
    }

    public Sponsor updateSponsor (String id, Sponsor sponsor){
        Sponsor sponsorBd = findById(id);
        if (sponsorBd != null) {
            sponsorBd.setNameSponsor(sponsor.getNameSponsor());
            return saveSponsor(sponsorBd);
        }
        throw new RuntimeException("Patrocinador no encontrado");
    }
}
