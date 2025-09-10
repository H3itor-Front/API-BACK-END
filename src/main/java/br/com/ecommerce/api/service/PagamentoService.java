package br.com.ecommerce.api.service;

import br.com.ecommerce.api.model.Item;
import br.com.ecommerce.api.model.Pagamento;
import br.com.ecommerce.api.repository.PagamentoRepository;
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
    public Pagamento cadastrarPagamento(Pagamento pg) {
        return pagamentoRepository.save(pg);
    }
    public Pagamento buscarPorid(int id){

        return pagamentoRepository.findById(id).orElse(null);
    }
    public Pagamento deletarPagamento(int id) {
        Pagamento pg = buscarPorid(id);
        if (pg == null) {
            return null;
        }
        pagamentoRepository.delete(pg);
        return pg;
    }
}
