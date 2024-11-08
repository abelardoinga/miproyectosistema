package com.demodj.demo_examen.Service.Impl;

import com.demodj.demo_examen.Entity.Estudiante;
import com.demodj.demo_examen.Repository.EstudianteRepository;
import com.demodj.demo_examen.Service.EstudianteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@Service
public class EstudianteServiceImpl implements EstudianteService {

    private final EstudianteRepository estudianteRepository;
    @Autowired
    public EstudianteServiceImpl( EstudianteRepository estudianteRepository) {

        this.estudianteRepository = estudianteRepository;

    }

    @Override
    public List<Estudiante> getAllEstudiante() {
        return estudianteRepository.findAll();
    }

    @Override
    public void addEstudiante(Estudiante estudiante) {
        estudianteRepository.save(estudiante);

    }
    @Override
    public Estudiante buscarPorId(Long id) {
        // Usamos findById de JpaRepository, que devuelve un Optional
        return estudianteRepository.findById(id).orElse(null);
        // Si no se encuentra el estudiante, devuelve null
    }

    @Override
    public void deleteEstudiante(Long id) {
        if (estudianteRepository.existsById(id)) {
            estudianteRepository.deleteById(id);
        } else {
            throw new RuntimeException("Estudiante no encontrado");
        }
    }

    @Override
    public void updateEstudiante(Estudiante estudiante) {
        estudianteRepository.save(estudiante); // Guarda el estudiante actualizado en la base de datos
    }


}

