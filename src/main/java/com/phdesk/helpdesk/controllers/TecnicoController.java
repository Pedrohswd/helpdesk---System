package com.phdesk.helpdesk.controllers;

import com.phdesk.helpdesk.domain.Tecnico;
import com.phdesk.helpdesk.domain.dtos.TecnicoDTO;
import com.phdesk.helpdesk.services.TecnicoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(value = "/tecnicos")
public class TecnicoController {

    @Autowired
    private TecnicoService tecnicoService;

    @GetMapping(value = "/{id}")
    public ResponseEntity<TecnicoDTO> findById(@PathVariable Integer id){
        Tecnico obj = tecnicoService.findByID(id);
        return ResponseEntity.ok().body(new TecnicoDTO(obj));
    }

}
