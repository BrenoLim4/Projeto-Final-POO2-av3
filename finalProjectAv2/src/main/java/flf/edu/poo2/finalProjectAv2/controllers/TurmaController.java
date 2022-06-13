package flf.edu.poo2.finalProjectAv2.controllers;

import flf.edu.poo2.finalProjectAv2.domain.entities.Professor;
import flf.edu.poo2.finalProjectAv2.domain.entities.Turma;
import flf.edu.poo2.finalProjectAv2.domain.services.ProfessorServices;
import flf.edu.poo2.finalProjectAv2.domain.services.TurmaServices;
import org.jetbrains.annotations.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.lang.NonNull;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "turma")
public class TurmaController {

    @Autowired
    private TurmaServices turmaServices;

    @GetMapping
    public ResponseEntity<List<Turma>> findAll(){
        List<Turma> turma = turmaServices.findAll();
        return ResponseEntity.ok().body(turma);
    }

    @GetMapping(value = "buscar/{id}")
    public ResponseEntity<Turma> findById(@PathVariable Long id){
        Turma turma = turmaServices.findById(id);
        return ResponseEntity.ok(turma);
    }

    @DeleteMapping(value = "{id}")
    public ResponseEntity<String> deletar(@PathVariable Long id ){
        turmaServices.deleteById(id);
        return new ResponseEntity<String>("Excluído com sucesso", HttpStatus.OK);
    }

    @PostMapping(value = "salvar")
    public ResponseEntity<Turma> salvar(@RequestParam Turma turma){
        Turma t = turmaServices.salvar(turma);
        return ResponseEntity.ok(t);
    }

    @PutMapping(value = "update")
    public ResponseEntity<Turma> update(@RequestParam @NonNull Long id, @RequestBody @NotNull Turma turma){
        if(turma.getId() == null){
            turma.setId(id);
        }
        Turma t = turmaServices.salvar(turma);
        return ResponseEntity.ok(t);
    }
}
