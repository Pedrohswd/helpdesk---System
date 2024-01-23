package com.phdesk.helpdesk.services;

import com.phdesk.helpdesk.domain.Chamado;
import com.phdesk.helpdesk.domain.Cliente;
import com.phdesk.helpdesk.domain.Tecnico;
import com.phdesk.helpdesk.domain.enums.Perfil;
import com.phdesk.helpdesk.domain.enums.Prioridade;
import com.phdesk.helpdesk.domain.enums.Status;
import com.phdesk.helpdesk.repositories.ChamadoRepository;
import com.phdesk.helpdesk.repositories.ClienteRepository;
import com.phdesk.helpdesk.repositories.TecnicoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;

@Service
public class DBservice {

    @Autowired
    private TecnicoRepository tecnicoRepository;
    @Autowired
    private ClienteRepository clienteRepository;
    @Autowired
    private ChamadoRepository chamadoRepository;

    public void instanciaDB() {
        Tecnico tec1 = new Tecnico(null, "Valdir Cezar", "040.198.751-54", "Valdir@mail.com", "123");
        tec1.addPerfil(Perfil.ADMIN);

        Cliente cli1 = new Cliente(null, "Linus Torvalds", "268.022.200-83", "torvalds@mail.com", "123");

        Chamado chamado1 = new Chamado(null, Prioridade.MEDIA, Status.ANDAMENTO, "Chamado 01", "Primeiro Chamado", tec1, cli1);
        tecnicoRepository.saveAll(Arrays.asList(tec1));
        clienteRepository.saveAll(Arrays.asList(cli1));
        chamadoRepository.saveAll(Arrays.asList(chamado1));
    }
}
