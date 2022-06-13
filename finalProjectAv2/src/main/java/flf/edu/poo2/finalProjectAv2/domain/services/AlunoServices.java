package flf.edu.poo2.finalProjectAv2.domain.services;

import flf.edu.poo2.finalProjectAv2.domain.entities.Aluno;
import flf.edu.poo2.finalProjectAv2.domain.repositories.AlunoRepository;
import flf.edu.poo2.finalProjectAv2.domain.services.exceptions.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AlunoServices {
    @Autowired
    AlunoRepository alunoRepository;

    public Aluno salvar(Aluno aluno){
        return alunoRepository.save(aluno);
    }

    public Aluno atualizar(Aluno aluno){
        if(aluno.getId() != null){
            return alunoRepository.save(aluno);
        }
        throw new RuntimeException("Nenhum aluno encontrado para o filtro especificado");
    }

    public void deleteById(Long id){
        alunoRepository.deleteById(id);
    }

    public List<Aluno> findAll(){
        return alunoRepository.findAll();
    }

    public Aluno findById(Long id){
        return alunoRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException(id));
    }
}
