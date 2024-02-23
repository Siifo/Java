package com.cursoPA.t2r.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cursoPA.t2r.entity.Departamento;
import com.cursoPA.t2r.repository.departamentoRepository;
@Service
public class departamentoService {
    @Autowired
    departamentoRepository DepartamentoRepository;

    public List<Departamento> getDepaList(){
        return DepartamentoRepository.findAll();
    }
    public Optional<Departamento> getDepa(Long id){
        return DepartamentoRepository.findById(id);
    }

    public void saveOrUpdate(Departamento departamento){
        DepartamentoRepository.save(departamento);
    }

    public void delete(Long id){
        DepartamentoRepository.deleteById(id);
    }
    
}
