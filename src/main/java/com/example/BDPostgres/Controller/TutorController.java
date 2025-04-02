package com.example.BDPostgres.Controller;

import com.example.BDPostgres.Model.Tutor;
import com.example.BDPostgres.Repository.TutorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/tutores")
public class TutorController {

    @Autowired
    private TutorRepository tutorRepository;

    @GetMapping
    public List<Tutor> getAllTutores() {
        return tutorRepository.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Tutor> getTutorById(@PathVariable Long id) {
        return tutorRepository.findById(id)
                .map(tutor -> ResponseEntity.ok().body(tutor))
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public Tutor createTutor(@RequestBody Tutor tutor) {
        return tutorRepository.save(tutor);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Tutor> updateTutor(@PathVariable Long id, @RequestBody Tutor tutorDetails) {
        return tutorRepository.findById(id)
                .map(tutor -> {
                    tutor.setNombreTutor(tutorDetails.getNombreTutor());
                    tutor.setTelefono(tutorDetails.getTelefono());
                    tutor.setEstudiante(tutorDetails.getEstudiante());
                    Tutor updatedTutor = tutorRepository.save(tutor);
                    return ResponseEntity.ok(updatedTutor);
                })
                .orElse(ResponseEntity.notFound().build());
    }

    /*@DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteTutor(@PathVariable Long id) {
        return tutorRepository.findById(id)
                .map(tutor -> {
                    tutorRepository.delete(tutor);
                    return ResponseEntity.noContent().build();
                })
                .orElse(ResponseEntity.notFound().build());
    }*/
}