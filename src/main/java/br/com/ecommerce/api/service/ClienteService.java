package br.com.ecommerce.api.service;

import br.com.ecommerce.api.repository.ClienteRepository;
import br.com.ecommerce.api.model.Cliente;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClienteService {
    // Injecao de Dependencia
    // Falar que Service Depende de alguém
    private final ClienteRepository clienteRepository;

    public ClienteService(ClienteRepository repo) {
        this.clienteRepository = repo;
    }

    public List<Cliente> listarTodos() {

        return clienteRepository.findAll();
    }

    public Cliente cadastrarCliente(Cliente cl) {
        return clienteRepository.save(cl);
    }

}
