package flf.edu.poo2.finalProjectAv2.domain.repositories;

import flf.edu.poo2.finalProjectAv2.domain.entities.Turma;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TurmaRepository extends JpaRepository<Turma, Long> {
}
