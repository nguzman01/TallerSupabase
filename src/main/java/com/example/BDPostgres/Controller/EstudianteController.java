package com.example.BDPostgres.Controller;

import com.example.BDPostgres.Model.Estudiante;
import com.example.BDPostgres.Repository.EstudianteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/estudiantes")
public class EstudianteController {

    @Autowired
    private EstudianteRepository estudianteRepository;

    @GetMapping
    public List<Estudiante> getAllEstudiantes() {
        return estudianteRepository.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Estudiante> getEstudianteById(@PathVariable Long id) {
        return estudianteRepository.findById(id)
                .map(estudiante -> ResponseEntity.ok().body(estudiante))
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public Estudiante createEstudiante(@RequestBody Estudiante estudiante) {
        return estudianteRepository.save(estudiante);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Estudiante> updateEstudiante(@PathVariable Long id, @RequestBody Estudiante estudianteDetails) {
        return estudianteRepository.findById(id)
                .map(estudiante -> {
                    estudiante.setCodigo(estudianteDetails.getCodigo());
                    estudiante.setNombre(estudianteDetails.getNombre());
                    estudiante.setTelefono(estudianteDetails.getTelefono());
                    Estudiante updatedEstudiante = estudianteRepository.save(estudiante);
                    return ResponseEntity.ok(updatedEstudiante);
                })
                .orElse(ResponseEntity.notFound().build());
    }

    /*@DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteEstudiante(@PathVariable Long id) {
        return estudianteRepository.findById(id).map(estudiante -> {
            estudianteRepository.delete(estudiante);
                    return ResponseEntity.noContent().build();
                })
                .orElse(ResponseEntity.notFound().build());
    }*/
}
