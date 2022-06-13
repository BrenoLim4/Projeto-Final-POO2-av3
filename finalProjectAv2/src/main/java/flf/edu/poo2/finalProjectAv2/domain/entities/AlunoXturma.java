package flf.edu.poo2.finalProjectAv2.domain.entities;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(schema = "poo2_av3", name = "aluno_x_turma")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class AlunoXturma {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @JoinColumn(name = "id_aluno", referencedColumnName = "id", nullable = false)
    @ManyToOne(fetch = FetchType.EAGER)
    private Aluno aluno;
    @JoinColumn(name = "id_turma", referencedColumnName = "id", nullable = false)
    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.REMOVE)
    private Turma turma;

}
