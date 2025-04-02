package com.example.BDPostgres.Model;


import jakarta.persistence.*;// Importa las anotaciones de JPA para la persistencia de datos.
import lombok.Getter;
import lombok.Setter;

import java.util.Set;//Importa la clase Set para manejar colecciones de inscripciones.
@Getter //Genera automáticamente los métodos getter para todos los campos de la clase.
@Setter //Genera automáticamente los métodos setter para todos los campos de la clase.
@Entity //@Entity-->  indica que la clase es una entidad JPA.
public class Curso {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nombreCurso;
    private String descripcion;

    // @OneToMany --> crea una elación uno a muchos con la entidad Inscripcion
    @OneToMany(mappedBy = "curso", cascade = CascadeType.ALL)
    private Set<Inscripcion> inscripciones;


}