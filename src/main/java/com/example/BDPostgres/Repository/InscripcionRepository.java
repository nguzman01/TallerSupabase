package com.example.BDPostgres.Repository;

import com.example.BDPostgres.Model.Inscripcion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface InscripcionRepository extends JpaRepository<Inscripcion, Long> {
    // Puedes agregar métodos personalizados aquí si es necesario
}
