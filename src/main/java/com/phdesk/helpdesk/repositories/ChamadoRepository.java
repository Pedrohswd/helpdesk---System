package com.phdesk.helpdesk.repositories;

import com.phdesk.helpdesk.domain.Chamado;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ChamadoRepository extends JpaRepository<Chamado, Integer> {

}
