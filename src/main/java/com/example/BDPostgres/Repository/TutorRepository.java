package com.example.BDPostgres.Repository;

import com.example.BDPostgres.Model.Tutor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TutorRepository extends JpaRepository<Tutor, Long> {
    // Puedes agregar métodos personalizados aquí si es necesario
}
