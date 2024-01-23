package com.phdesk.helpdesk.services;

import com.phdesk.helpdesk.domain.Pessoa;
import com.phdesk.helpdesk.domain.Cliente;
import com.phdesk.helpdesk.domain.dtos.ClienteDTO;
import com.phdesk.helpdesk.repositories.ClienteRepository;
import com.phdesk.helpdesk.repositories.PessoaRepository;
import com.phdesk.helpdesk.services.exceptions.DataIntegrityViolationException;
import com.phdesk.helpdesk.services.exceptions.ObjectnotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ClienteService {
    @Autowired
    private ClienteRepository clienteRepository;

    @Autowired
    private PessoaRepository pessoaRepository;

    public Cliente findByID(Integer id) {
        Optional<Cliente> obj = clienteRepository.findById(id);
        return obj.orElseThrow(() -> new ObjectnotFoundException("Objeto não encontrado! id: " + id));
    }

    public List<Cliente> findAll() {
        return clienteRepository.findAll();
    }

    public Cliente create(ClienteDTO objDTO) {
        objDTO.setId(null);
        validaPorCpfEmail(objDTO);
        Cliente newObj = new Cliente(objDTO);
        return clienteRepository.save(newObj);
    }

    private void validaPorCpfEmail(ClienteDTO objDTO) {
        Optional<Pessoa> obj = pessoaRepository.findByCpf(objDTO.getCpf());
        if(obj.isPresent() && obj.get().getId() != objDTO.getId()){
            throw new DataIntegrityViolationException("Cpf já cadastrado no sistema!");
        }
        obj = pessoaRepository.findByEmail(objDTO.getEmail());
        if(obj.isPresent() && obj.get().getId() != objDTO.getId()){
            throw new DataIntegrityViolationException("E-mail já cadastrado no sistema!");
        }
    }

    public Cliente update(Integer id, ClienteDTO clienteDTO) {
        clienteDTO.setId(id);
        Cliente oldObj = findByID(id);
        validaPorCpfEmail(clienteDTO);
        oldObj = new Cliente(clienteDTO);
        return clienteRepository.save(oldObj);
    }

    public void delete(Integer id) {
        Cliente obj = findByID(id);
        if(obj.getChamados().size() > 0){
            throw new DataIntegrityViolationException("Cliente possui ordens de serviços e não pode ser deletado!");
        }
        clienteRepository.deleteById(id);

    }
}
