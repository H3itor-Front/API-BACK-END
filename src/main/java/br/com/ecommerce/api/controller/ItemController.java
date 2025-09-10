package br.com.ecommerce.api.controller;

import br.com.ecommerce.api.model.Cliente;
import br.com.ecommerce.api.model.Item;
import br.com.ecommerce.api.service.ItemService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/item")
public class ItemController {

    private final ItemService itemService;

    public ItemController(ItemService service) {
        itemService = service;
    }

    // Listar Todos
    @GetMapping
    public ResponseEntity<List<Item>> listarPedido() {
        // 1. Pegar a Lista de clientes
        List<Item> item = itemService.listarTodos();

        return ResponseEntity.ok(item);
    }
    @PostMapping
    public ResponseEntity<Item> cadastrarItem(@RequestBody Item item) {
        item = itemService.cadastrarItem(item);
        // Codigo 201 - CREATED
        return ResponseEntity.status(HttpStatus.CREATED).body(item);


    }
    @GetMapping("/{id}")
    public ResponseEntity<?> buscarItemPorId(@PathVariable int id){
        Item it = itemService.buscarPorid(id);

        if (it == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Item" + id + " não encontrado");
        }
        return ResponseEntity.ok(it);
    }

    @DeleteMapping("/{id}")

    public ResponseEntity<?> deletarItem(@PathVariable int id){
        Item it = itemService.deletarItem(id);

        if (it == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Item" + id + " Não encontrado");
        }
        return ResponseEntity.ok(it);
    }
}
