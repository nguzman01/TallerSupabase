package com.example.BDPostgres.Controller;

import com.example.BDPostgres.Model.Inscripcion;
import com.example.BDPostgres.Repository.InscripcionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/inscripciones")
public class InscripcionController {

    @Autowired
    private InscripcionRepository inscripcionRepository;

    @GetMapping
    public List<Inscripcion> getAllInscripciones() {
        return inscripcionRepository.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Inscripcion> getInscripcionById(@PathVariable Long id) {
        return inscripcionRepository.findById(id)
                .map(inscripcion -> ResponseEntity.ok().body(inscripcion))
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public Inscripcion createInscripcion(@RequestBody Inscripcion inscripcion) {
        return inscripcionRepository.save(inscripcion);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Inscripcion> updateInscripcion(@PathVariable Long id, @RequestBody Inscripcion inscripcionDetails) {
        return inscripcionRepository.findById(id)
                .map(inscripcion -> {
                    inscripcion.setEstudiante(inscripcionDetails.getEstudiante());
                    inscripcion.setCurso(inscripcionDetails.getCurso());
                    Inscripcion updatedInscripcion = inscripcionRepository.save(inscripcion);
                    return ResponseEntity.ok(updatedInscripcion);
                })
                .orElse(ResponseEntity.notFound().build());
    }

    /*@DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteInscripcion(@PathVariable Long id) {
        return inscripcionRepository.findById(id)
                .map(Inscripcion -> {
                    inscripcionRepository.delete(Inscripcion);
                    return ResponseEntity.noContent().build();
                })
                .orElse(ResponseEntity.notFound().build());
    }*/
}