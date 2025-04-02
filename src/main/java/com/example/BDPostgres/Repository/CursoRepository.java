package com.example.BDPostgres.Repository;


import com.example.BDPostgres.Model.Curso;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CursoRepository extends JpaRepository<Curso, Long> {
    // Puedes agregar métodos personalizados aquí si es necesario
}
