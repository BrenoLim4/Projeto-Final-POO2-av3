package flf.edu.poo2.finalProjectAv2.controllers;

import flf.edu.poo2.finalProjectAv2.domain.entities.Aluno;
import flf.edu.poo2.finalProjectAv2.domain.services.AlunoServices;
import org.jetbrains.annotations.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.lang.NonNull;
import org.springframework.web.bind.annotation.*;

import javax.websocket.server.PathParam;
import java.util.List;

@RestController
@RequestMapping(value = "aluno")
public class AlunoController {

    @Autowired
    private AlunoServices alunoServices;

    @GetMapping
    public ResponseEntity<List<Aluno>> findAll(){
        List<Aluno> alunos = alunoServices.findAll();
        return ResponseEntity.ok().body(alunos);
    }

    @GetMapping(value = "buscar/{id}")
    public ResponseEntity<Aluno> findById(@PathVariable Long id){
        Aluno aluno = alunoServices.findById(id);
        return ResponseEntity.ok(aluno);
    }

    @DeleteMapping(value = "{id}")
    public ResponseEntity<String> deletar(@PathVariable Long id ){
        alunoServices.deleteById(id);
        return new ResponseEntity<String>("Excluído com sucesso", HttpStatus.OK);
    }

    @PostMapping(value = "salvar")
    public ResponseEntity<Aluno> salvar(@RequestBody Aluno aluno){
        Aluno alunoSave = alunoServices.salvar(aluno);
        return ResponseEntity.ok(alunoSave);
    }

    @PutMapping(value = "update")
    public ResponseEntity<Aluno> update(@RequestParam @NonNull Long id, @RequestBody Aluno aluno){
        aluno.setId(id);
        Aluno aln = alunoServices.atualizar(aluno);
        return ResponseEntity.ok(aln);
    }

}
