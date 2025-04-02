package com.example.BDPostgres.Model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class Inscripcion {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // Relación muchos a uno con la entidad Estudiante
    @ManyToOne// Indica que múltiples inscripciones pueden estar asociadas a un único estudiante.
    @JoinColumn(name = "estudiante_id") // Especifica la columna en la tabla Inscripcion que referenciará a la tabla Estudiante.
    private Estudiante estudiante;  // Referencia al estudiante asociado a esta inscripción.

    // Relación muchos a uno con la entidad Curso.
    @ManyToOne// Indica que múltiples inscripciones pueden estar asociadas a un único curso.
    @JoinColumn(name = "curso_id") // Especifica la columna en la tabla Inscripcion que referenciará a la tabla Curso.
    private Curso curso; // Referencia al curso asociado a esta inscripción.


}
