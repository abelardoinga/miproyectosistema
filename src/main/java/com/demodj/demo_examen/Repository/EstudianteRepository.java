package com.demodj.demo_examen.Repository;

import com.demodj.demo_examen.Entity.Estudiante;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EstudianteRepository extends JpaRepository<Estudiante,Long> {
}
