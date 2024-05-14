package com.uptc.frmw.Services;

import com.uptc.frmw.Entities.Edition;
import com.uptc.frmw.Entities.Stage;
import com.uptc.frmw.Repositories.StageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StageService {

    @Autowired
    private StageRepository stageRepository;

    @Autowired
    private EditionService editionService;

    public List<Stage> findAll(){
        return stageRepository.findAll();
    }

    public Stage findById(long idStage) {
        return stageRepository.findById(idStage).orElse(null);
    }

    public List<Stage> findStageByEditionId(short idEdition){
        return stageRepository.findByIdEdition(idEdition);
    }

    public void deleteById(long idStage) {
        stageRepository.deleteById(idStage);
    }

    public Stage saveStage(Stage stage) {
        Edition edition = editionService.findById(stage.getIdEdition());
        stage.setEdition(edition);
        return stageRepository.save(stage);
    }

    public Stage updateStage (long id, Stage stage){
        Stage stageBd = findById(id);
        if (stageBd != null) {
            stageBd.setOrigin(stage.getOrigin());
            stageBd.setDestination(stage.getDestination());
            stageBd.setLongitude(stage.getLongitude());
            stageBd.setTypeStage(stage.getTypeStage());
            stageBd.setIdEdition(stage.getIdEdition());
            return saveStage(stageBd);
        }
        throw new RuntimeException("Etapa no encontrada");
    }
}
