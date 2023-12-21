package com.phdesk.helpdesk.domain;

import com.phdesk.helpdesk.domain.Pessoa;

import java.util.ArrayList;
import java.util.List;

public class Tecnico extends Pessoa {
    private List<Chamado> chamados = new ArrayList<>();
}
