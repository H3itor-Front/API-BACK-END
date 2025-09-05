package br.com.ecommerce.api.service;

import br.com.ecommerce.api.repository.ProdutoRepository;
import br.com.ecommerce.api.model.Produto;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProdutoService {
    // Injecao de Dependencia
    // Falar que Service Depende de alguém
    private final ProdutoRepository produtoRepository;

    public ProdutoService(ProdutoRepository repo) {
        this.produtoRepository = repo;
    }

    public List<Produto> listarTodos() {

        return produtoRepository.findAll();
    }

}
