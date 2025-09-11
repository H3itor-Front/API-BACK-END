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
    public Cliente buscarPorid(int id){

        return clienteRepository.findById(id).orElse(null);
    }
    public Cliente deletarCliente(int id) {
        Cliente cl = buscarPorid(id);
        if (cl == null) {
            return null;
        }
        clienteRepository.delete(cl);
        return cl;
    }
    public Cliente atualizarCliente(int id, Cliente clienteNovo) {
       Cliente clienteAntigo = buscarPorid(id);

       if (clienteAntigo == null) {
           return null;
       }
       clienteAntigo.setSenha(clienteNovo.getSenha());
       clienteAntigo.setNomeCompleto(clienteNovo.getNomeCompleto());
       clienteAntigo.setEmail(clienteNovo.getEmail());
       clienteAntigo.setTelefone(clienteNovo.getTelefone());
       clienteAntigo.setDataCadastro(clienteNovo.getDataCadastro());
       return clienteRepository.save(clienteAntigo);
    }

}
