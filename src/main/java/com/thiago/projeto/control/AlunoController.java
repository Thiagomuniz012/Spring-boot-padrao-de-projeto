package com.thiago.projeto.control;

import com.thiago.projeto.model.Aluno;
import com.thiago.projeto.model.AlunoRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin
@RestController
@RequestMapping("/aluno")
public class AlunoController {

    @Autowired
    AlunoRepository repository;

    @GetMapping({"", "/"})
    public List<Aluno> getAluno() {
        return repository.findAll(Sort.by("nome"));
    }

    @PostMapping({"", "/"})
    public Aluno insere(@RequestBody Aluno aluno) {
        return repository.save(aluno);
    }

    @PutMapping({"", "/"})
    public Aluno atualiza(@RequestBody Aluno aluno) {
        if (aluno.getId() != null) {
            return repository.save(aluno);
        }
        return null;
    }

    @DeleteMapping("/{id}")
    public String exclui(@PathVariable("id") Long id) {
        if (id != null) {
            repository.deleteById(id);
            return "Excluído";
        }
        return null;
    }
}
