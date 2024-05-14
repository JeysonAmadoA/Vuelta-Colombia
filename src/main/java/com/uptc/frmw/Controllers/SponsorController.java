package com.uptc.frmw.Controllers;

import com.uptc.frmw.Entities.Edition;
import com.uptc.frmw.Entities.Sponsor;
import com.uptc.frmw.Services.SponsorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/sponsor")
public class SponsorController {

    @Autowired
    private SponsorService sponsorService;

    @GetMapping
    public List<Sponsor> getAll(){
        return sponsorService.findAll();
    }

    @GetMapping("/{idSponsor}")
    public Sponsor getById(@PathVariable String idSponsor){
        return sponsorService.findById(idSponsor);
    }

    @PostMapping
    public Sponsor saveSponsor(@RequestBody Sponsor sponsor){
        return sponsorService.saveSponsor(sponsor);
    }

    @DeleteMapping("/{idSponsor}")
    public void deleteById(@PathVariable String idSponsor){
        sponsorService.deleteById(idSponsor);
    }

    @PutMapping("/{id}")
    public Sponsor updateSponsor(@PathVariable String id, @RequestBody Sponsor sponsor){
        return sponsorService.updateSponsor(id, sponsor);
    }
}
