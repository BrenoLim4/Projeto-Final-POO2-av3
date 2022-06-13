package flf.edu.poo2.finalProjectAv2.domain.entities;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(schema = "poo2_av3", name = "professor")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Professor implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(length = 14, unique = true)
    private String cpf;
    @Column(length = 100, nullable = false)
    private String nome;
    @Column(precision = 2, scale = 2)
    private Double salario;
}
