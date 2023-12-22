package com.phdesk.helpdesk;

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
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Arrays;

@SpringBootApplication
public class HelpdeskApplication {
    public static void main(String[] args) {
        SpringApplication.run(HelpdeskApplication.class, args);
    }

}
