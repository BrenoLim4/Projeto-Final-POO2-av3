package flf.edu.poo2.finalProjectAv2.domain.services;

import flf.edu.poo2.finalProjectAv2.domain.entities.Professor;
import flf.edu.poo2.finalProjectAv2.domain.entities.Turma;
import flf.edu.poo2.finalProjectAv2.domain.repositories.ProfessorRepository;
import flf.edu.poo2.finalProjectAv2.domain.repositories.TurmaRepository;
import flf.edu.poo2.finalProjectAv2.domain.services.exceptions.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TurmaServices {

    @Autowired
    TurmaRepository turmaRepository;

    public Turma salvar(Turma turma){
        return turmaRepository.save(turma);
    }

    public void deleteById(Long id){
        turmaRepository.deleteById(id);
    }

    public List<Turma> findAll(){
        return turmaRepository.findAll();
    }

    public Turma findById(Long id){
        return turmaRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException(id));
    }
}
