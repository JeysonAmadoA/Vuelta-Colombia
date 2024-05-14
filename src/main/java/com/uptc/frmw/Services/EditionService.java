package com.uptc.frmw.Services;

import com.uptc.frmw.Entities.Edition;
import com.uptc.frmw.Repositories.EditionRepository;
import com.uptc.frmw.Repositories.TeamHistoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EditionService {

    @Autowired
    private EditionRepository editionRepository;

    public List<Edition> findAll(){
        return editionRepository.findAll();
    }

    public Edition findById(Short id){
        Optional<Edition> edition = editionRepository.findById(id);
        return edition.orElse(null);
    }

    public Edition saveEdition(Edition edition) {
        return editionRepository.save(edition);
    }

    public void deleteById(short idEdition) {
        editionRepository.deleteById(idEdition);
    }

    public Edition updateEdition (short id, Edition edition){
        Edition editionBd = findById(id);
        if (editionBd != null) {
            editionBd.setStartDate(edition.getStartDate());
            editionBd.setEndDate(edition.getEndDate());
            return saveEdition(editionBd);
        }
        throw new RuntimeException("Edición no encontrada");
    }
}
