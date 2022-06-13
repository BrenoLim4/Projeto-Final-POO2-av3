package flf.edu.poo2.finalProjectAv2.TUnit;

import flf.edu.poo2.finalProjectAv2.domain.entities.Aluno;
import flf.edu.poo2.finalProjectAv2.domain.services.AlunoServices;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
public class AlunoServicesTest {

    @Autowired
    private AlunoServices alunoServices;

    @Test
    public void save(){
        Aluno aluno = Aluno.builder()
                .cpf("25411255412")
                .matricula("5555555")
                .nome("Breno Lima")
                .build();
        alunoServices.salvar(aluno);
    }

    @Test
    public void findAll(){
        List<Aluno> alunos = alunoServices.findAll();
        alunos.forEach(aluno -> System.out.println(aluno.getCpf() + " - " + aluno.getNome()));
    }

    @Test
    public void findById(){
        Aluno aluno = alunoServices.findById(1L);
        System.out.println(aluno.toString());
    }
}
