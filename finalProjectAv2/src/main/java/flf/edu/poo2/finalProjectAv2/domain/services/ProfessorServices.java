package flf.edu.poo2.finalProjectAv2.domain.services;

import flf.edu.poo2.finalProjectAv2.domain.entities.Professor;
import flf.edu.poo2.finalProjectAv2.domain.repositories.ProfessorRepository;
import flf.edu.poo2.finalProjectAv2.domain.services.exceptions.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProfessorServices {

    @Autowired
    ProfessorRepository professorRepository;

    public Professor salvar(Professor professor){
        return professorRepository.save(professor);
    }

    public void deleteById(Long id){
        professorRepository.deleteById(id);
    }

    public List<Professor> findAll(){
        return professorRepository.findAll();
    }

    public Professor findById(Long id){
        return professorRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException(id));
    }

}
