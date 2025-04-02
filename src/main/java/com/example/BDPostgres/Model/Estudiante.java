package com.example.BDPostgres.Model;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


// Esto significa que la clase se mapeará a una tabla en la base de datos.
@Getter //Genera automáticamente los métodos getter para todos los campos de la clase.
@Setter //Genera automáticamente los métodos setter para todos los campos de la clase.
@NoArgsConstructor // Genera un constructor vacío
@AllArgsConstructor // Genera un constructor con todos los parámetros
@Entity //@Entity-->  indica que la clase es una entidad JPA.
public class Estudiante {
    @Id // Identificador único del estudiante, generado automáticamente
    /*@generateValues-> indica que el valor del campo anotado (en este caso, id)
    será generado automáticamente por la base de datos*/
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    //Variable
    private Long id;
    private long codigo; //
    private String nombre;
    private String telefono;

    //@OneToOne--> Relación uno a uno con la entidad Tutor.
    @OneToOne(mappedBy = "estudiante", cascade = CascadeType.ALL)
    private Tutor tutor;

    //constructor vacio
   /* public Estudiante() {
    }


    //constructor con parametros
    public Estudiante(Long id, long codigo, String nombre, String telefono, Tutor tutor) {
        this.id = id;
        this.codigo = codigo;
        this.nombre = nombre;
        this.telefono = telefono;
        this.tutor = tutor;
    }*/


    // Métodos getter y setter para acceder y modificar los atributos de la clase.

   /* public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public long getCodigo() {
        return codigo;
    }

    public void setCodigo(long codigo) {
        this.codigo = codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public Tutor getTutor() {
        return tutor;
    }

    public void setTutor(Tutor tutor) {
        this.tutor = tutor;
    }*/

}

