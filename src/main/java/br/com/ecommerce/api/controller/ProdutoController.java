package br.com.ecommerce.api.controller;

import br.com.ecommerce.api.model.Produto;
import br.com.ecommerce.api.service.ProdutoService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/produto")
public class ProdutoController {

    private final ProdutoService produtoService;

    public ProdutoController(ProdutoService service) {
        produtoService = service;
    }

    // Listar Todos
    @GetMapping
    public ResponseEntity<List<Produto>> listarProduto() {
        // 1. Pegar a Lista de clientes
        List<Produto> produto = produtoService.listarTodos();

        return ResponseEntity.ok(produto);
    }
}
