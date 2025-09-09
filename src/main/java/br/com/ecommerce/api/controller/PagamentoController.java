package br.com.ecommerce.api.controller;

import br.com.ecommerce.api.model.Pagamento;
import br.com.ecommerce.api.service.PagamentoService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/pagamento")
public class PagamentoController {

    private final PagamentoService pagamentoService;

    public PagamentoController(PagamentoService service) {
        pagamentoService = service;
    }

    // Listar Todos
    @GetMapping
    public ResponseEntity<List<Pagamento>> listarPedido() {
        // 1. Pegar a Lista de clientes
        List<Pagamento> pagamento = pagamentoService.listarTodos();

        return ResponseEntity.ok(pagamento);
    }
    @PostMapping
    public ResponseEntity<Pagamento> cadastrarPagamento(@RequestBody Pagamento pagamento) {
        pagamento = pagamentoService.cadastrarPagamento(pagamento);
        // Codigo 201 - CREATED
        return ResponseEntity.status(HttpStatus.CREATED).body(pagamento);
    }
}
