package flf.edu.poo2.finalProjectAv2.domain.repositories;

import flf.edu.poo2.finalProjectAv2.domain.entities.Aluno;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AlunoRepository extends JpaRepository<Aluno, Long> {

}
