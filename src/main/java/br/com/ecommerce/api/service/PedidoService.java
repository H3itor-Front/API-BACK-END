package br.com.ecommerce.api.service;

import br.com.ecommerce.api.model.Pedido;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PedidoService {
    // Injecao de Dependencia
    // Falar que Service Depende de alguém
    private final PedidoRepository pedidoRepository;

    public PedidoService(PedidoRepository repo2) {
        this.pedidoRepository = repo2;
    }

    public List<Pedido> listarTodos() {

        return pedidoRepository.findAll();
    }

}
