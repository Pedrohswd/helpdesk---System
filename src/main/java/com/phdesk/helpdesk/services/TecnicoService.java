package com.phdesk.helpdesk.services;

import com.phdesk.helpdesk.domain.Tecnico;
import com.phdesk.helpdesk.repositories.TecnicoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class TecnicoService {
    @Autowired
    private TecnicoRepository tecnicoRepository;

    public Tecnico findByID(Integer id){
        Optional<Tecnico> obj = tecnicoRepository.findById(id);
        return obj.orElse(null);
    }
}
