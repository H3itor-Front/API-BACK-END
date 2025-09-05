package br.com.ecommerce.api.controller;

import br.com.ecommerce.api.model.Item;
import br.com.ecommerce.api.service.ItemService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/produto")
public class ItemController {

    private final ItemService itemService;

    public ItemController(ItemService service) {
        itemService = service;
    }

    // Listar Todos
    @GetMapping
    public ResponseEntity<List<item>> listarPedido() {
        // 1. Pegar a Lista de clientes
        List<Item> item = itemService.listarTodos();

        return ResponseEntity.ok(item);
    }
}
