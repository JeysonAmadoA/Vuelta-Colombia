package com.uptc.frmw.Services;

import com.uptc.frmw.Entities.Edition;
import com.uptc.frmw.Entities.Podium;
import com.uptc.frmw.Entities.Runner;
import com.uptc.frmw.Entities.Stage;
import com.uptc.frmw.Repositories.PodiumRepository;
import com.uptc.frmw.Repositories.RunnerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PodiumService {

    @Autowired
    private PodiumRepository podiumRepository;

    @Autowired
    private RunnerService runnerService;

    @Autowired
    private StageService stageService;

    public List<Podium> findAll(){
        return podiumRepository.findAll();
    }

    public Podium findById(long idPodium) {
        return podiumRepository.findById(idPodium).orElse(null);
    }

    public List<Podium> findPodiumByRunnerId(long idRunner){
        return podiumRepository.findByIdRunner(idRunner);
    }

    public List<Podium> findPodiumByStageId(long idStage){
        return podiumRepository.findByIdStage(idStage);
    }

    public void deleteById(long idPodium) {
        podiumRepository.deleteById(idPodium);
    }

    public Podium savePodium(Podium podium) {
        Runner runner = runnerService.findById(podium.getIdRunner());
        Stage stage = stageService.findById(podium.getIdStage());
        podium.setRunner(runner);
        podium.setStage(stage);
        return podiumRepository.save(podium);
    }

    public Podium updatePodium (long id, Podium podium){
        Podium podiumBd = findById(id);
        if (podiumBd != null) {
            podiumBd.setIdRunner(podium.getIdRunner());
            podiumBd.setIdStage(podium.getIdStage());
            podiumBd.setPosition(podium.getPosition());
            podiumBd.setTimeMinutes(podium.getTimeMinutes());
            return savePodium(podiumBd);
        }
        throw new RuntimeException("Podio no encontrado");
    }
}
