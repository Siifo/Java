package com.cursoPA.t2r.service;

import java.util.List;
import java.util.Optional;
import java.util.concurrent.CompletableFuture;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import com.cursoPA.t2r.entity.Empleado;
import com.cursoPA.t2r.repository.empleadoRepository;

@Service
public class empleadoService {
    @Autowired
    empleadoRepository EmpleadoRepository;
    //deberiamos recuperar el empleado seleccionado, mediante el id
    @Async
    public CompletableFuture<Empleado> getEmpleadoByIdAsync(Long id){
        return CompletableFuture.completedFuture(EmpleadoRepository.findById(id).orElse(null));
    }
    
    public Empleado findByCorreo(String correo, String ciudad){
        return EmpleadoRepository.findByCorreo_electronico(correo, ciudad);
    }

    public List<Empleado> getEmpleadoList(){
        return EmpleadoRepository.findAll();
    }
    public Optional<Empleado> getEmpleado(Long id){
        return EmpleadoRepository.findById(id);
    }

    public void saveOrUpdate(Empleado empleado){
        EmpleadoRepository.save(empleado);
    }

    public void delete(Long id){
        EmpleadoRepository.deleteById(id);
    }
}
