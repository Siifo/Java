package com.cursoPA.t2r.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cursoPA.t2r.entity.Vivienda;
import com.cursoPA.t2r.repository.viviendaRepository;

@Service
public class viviendaService {
    
    @Autowired
    viviendaRepository ViviendaRepository;

    public List<Vivienda> getViviendaList(){
        return ViviendaRepository.findAll();
    }
    public Optional<Vivienda> getVivienda(Long id){
        return ViviendaRepository.findById(id);
    }

    public void saveOrUpdate(Vivienda producto){
        ViviendaRepository.save(producto);
    }

    public void delete(Long id){
        ViviendaRepository.deleteById(id);
    }
}
