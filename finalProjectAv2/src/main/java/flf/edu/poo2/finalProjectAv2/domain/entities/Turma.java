package flf.edu.poo2.finalProjectAv2.domain.entities;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Table(schema = "poo2_av3", name = "turma")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Turma implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false, length = 100)
    private String disciplina;
    @Column
    private Integer ano;
    @JoinColumn(name = "id_professor", referencedColumnName = "id")
    @ManyToOne
    private Professor professor;

}
