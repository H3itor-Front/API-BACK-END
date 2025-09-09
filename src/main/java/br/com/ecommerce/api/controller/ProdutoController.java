package br.com.ecommerce.api.controller;

import br.com.ecommerce.api.model.Cliente;
import br.com.ecommerce.api.model.Produto;
import br.com.ecommerce.api.service.ProdutoService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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

    @PostMapping
    public ResponseEntity<Produto> cadastrarProduto(@RequestBody Produto produto) {
        produto = produtoService.cadastrarProduto(produto);
        // Codigo 201 - CREATED
        return ResponseEntity.status(HttpStatus.CREATED).body(produto);
    }
}
