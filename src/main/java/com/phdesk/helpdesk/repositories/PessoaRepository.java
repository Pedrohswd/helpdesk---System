package com.phdesk.helpdesk.repositories;

import com.phdesk.helpdesk.domain.Pessoa;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PessoaRepository extends JpaRepository<Pessoa, Integer> {

}
