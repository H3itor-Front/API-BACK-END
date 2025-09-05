package br.com.ecommerce.api.controller;

import br.com.ecommerce.api.model.Pagamento;
import br.com.ecommerce.api.service.PagamentoService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/produto")
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
}
