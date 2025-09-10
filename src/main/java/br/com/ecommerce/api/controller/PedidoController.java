package br.com.ecommerce.api.controller;

import br.com.ecommerce.api.model.Item;
import br.com.ecommerce.api.model.Pedido;
import br.com.ecommerce.api.model.Produto;
import br.com.ecommerce.api.service.PedidoService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/pedido")
public class PedidoController {

    private final PedidoService pedidoService;

    public PedidoController(PedidoService service) {
        pedidoService = service;
    }

    // Listar Todos
    @GetMapping
    public ResponseEntity<List<Pedido>> listarPedido() {
        // 1. Pegar a Lista de clientes
        List<Pedido> pedido = pedidoService.listarTodos();

        return ResponseEntity.ok(pedido);
    }
    @PostMapping
    public ResponseEntity<Pedido> cadastrarPedido(@RequestBody Pedido pedido) {
        pedido = pedidoService.cadastrarPedido(pedido);
        // Codigo 201 - CREATED
        return ResponseEntity.status(HttpStatus.CREATED).body(pedido);
    }
    @GetMapping("/{id}")
    public ResponseEntity<?> buscarPedidoPorId(@PathVariable int id){
        Pedido pd = pedidoService.buscarPorid(id);

        if (pd == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Pedido " + id + " não encontrado");
        }
        return ResponseEntity.ok(pd);
    }

    @DeleteMapping("/{id}")

    public ResponseEntity<?> deletarPedido(@PathVariable int id){
        Pedido pd = pedidoService.deletarPedido(id);

        if (pd == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Pedido " + id + " Não encontrado");
        }
        return ResponseEntity.ok(pd);
    }
}
