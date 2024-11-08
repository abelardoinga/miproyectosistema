package com.demodj.demo_examen.Service;

import com.demodj.demo_examen.Entity.Estudiante;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EstudianteService {

    List<Estudiante> getAllEstudiante();

    void addEstudiante(Estudiante estudiante);

    void updateEstudiante(Estudiante estudiante);

    void deleteEstudiante(Long id);

    Estudiante buscarPorId(Long id);

}
