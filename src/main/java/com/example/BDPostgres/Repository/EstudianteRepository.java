package com.example.BDPostgres.Repository;

import com.example.BDPostgres.Model.Estudiante;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EstudianteRepository extends JpaRepository<Estudiante, Long> {



    // Puedes agregar métodos personalizados aquí si es necesario
}
