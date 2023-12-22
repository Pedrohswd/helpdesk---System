package com.phdesk.helpdesk.repositories;

import com.phdesk.helpdesk.domain.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClienteRepository extends JpaRepository<Cliente, Integer> {

}
