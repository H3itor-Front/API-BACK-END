package br.com.ecommerce.api.service;

import br.com.ecommerce.api.repository.PagamentoRepository;
import br.com.ecommerce.api.model.Pagamento;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PagamentoService {
    // Injecao de Dependencia
    // Falar que Service Depende de alguém
    private final PagamentoRepository pagamentoRepository;

    public PagamentoService(PagamentoRepository repo3) {
        this.pagamentoRepository = repo3;
    }

    public List<Pagamento> listarTodos() {

        return pagamentoRepository.findAll();
    }

}
