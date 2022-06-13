package flf.edu.poo2.finalProjectAv2.domain.entities;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(schema = "poo2_av3", name = "aluno")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Aluno implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(unique = true, length = 8, nullable = false)
    private String matricula;
    @Column(nullable = false, length = 100)
    private String nome;
    @Column(nullable = false, length = 14)
    private String cpf;
}
