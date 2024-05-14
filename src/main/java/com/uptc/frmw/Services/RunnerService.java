package com.uptc.frmw.Services;

import com.uptc.frmw.Entities.Runner;
import com.uptc.frmw.Repositories.RunnerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RunnerService {

    @Autowired
    private RunnerRepository runnerRepository;

    public List<Runner> findAll(){
        return runnerRepository.findAll();
    }

    public Runner findById(long id){
        Optional<Runner> runner = runnerRepository.findById(id);
        return runner.orElse(null);
    }

    public Runner saveRunner(Runner runner) {
        return runnerRepository.save(runner);
    }

    public void deleteById(long idRunner) {
        runnerRepository.deleteById(idRunner);
    }

    public Runner updateRunner (long id, Runner runner){
        Runner runnerBd = findById(id);
        if (runnerBd != null) {
            runnerBd.setNameRunner(runner.getNameRunner());
            runnerBd.setCountryBirth(runner.getCountryBirth());
            runnerBd.setDateBirth(runner.getDateBirth());
            return saveRunner(runnerBd);
        }
        throw new RuntimeException("Corredor no encontrado");
    }
}
