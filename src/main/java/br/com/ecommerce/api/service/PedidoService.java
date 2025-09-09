package br.com.ecommerce.api.service;


import br.com.ecommerce.api.model.Pedido;
import br.com.ecommerce.api.model.Produto;
import br.com.ecommerce.api.repository.PedidoRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PedidoService {
    // Injecao de Dependencia
    // Falar que Service Depende de alguém
    private final PedidoRepository pedidoRepository;

    public PedidoService(PedidoRepository repo4) {
        this.pedidoRepository = repo4;
    }

    public List<Pedido> listarTodos() {

        return pedidoRepository.findAll();
    }

    public Pedido cadastrarPedido(Pedido pe) {
        return pedidoRepository.save(pe);
    }
}
