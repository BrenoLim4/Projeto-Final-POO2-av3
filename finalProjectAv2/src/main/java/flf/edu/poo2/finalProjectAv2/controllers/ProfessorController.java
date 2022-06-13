package flf.edu.poo2.finalProjectAv2.controllers;

import flf.edu.poo2.finalProjectAv2.domain.entities.Aluno;
import flf.edu.poo2.finalProjectAv2.domain.entities.Professor;
import flf.edu.poo2.finalProjectAv2.domain.services.ProfessorServices;
import org.jetbrains.annotations.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.lang.NonNull;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "professor")
public class ProfessorController {

    @Autowired
    private ProfessorServices professorServices;

    @GetMapping
    public ResponseEntity<List<Professor>> findAll(){
        List<Professor> professores = professorServices.findAll();
        return ResponseEntity.ok().body(professores);
    }

    @GetMapping(value = "buscar/{id}")
    public ResponseEntity<Professor> findById(@PathVariable Long id){
        Professor professor = professorServices.findById(id);
        return ResponseEntity.ok(professor);
    }

    @DeleteMapping(value = "{id}")
    public ResponseEntity<String> deletar(@PathVariable Long id ){
        professorServices.deleteById(id);
        return new ResponseEntity<String>("Excluído com sucesso", HttpStatus.OK);
    }

    @PostMapping(value = "salvar")
    public ResponseEntity<Professor> salvar(@RequestParam Professor professor){
        Professor prof = professorServices.salvar(professor);
        return ResponseEntity.ok(prof);
    }

    @PutMapping(value = "update")
    public ResponseEntity<Professor> update(@RequestParam @NonNull Long id, @RequestBody @NotNull Professor professor){
        if(professor.getId() == null){
            professor.setId(id);
        }
        Professor prof = professorServices.salvar(professor);
        return ResponseEntity.ok(prof);
    }

}
