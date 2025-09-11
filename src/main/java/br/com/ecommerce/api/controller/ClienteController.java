package br.com.ecommerce.api.controller;

import br.com.ecommerce.api.model.Cliente;
import br.com.ecommerce.api.service.ClienteService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/clientes")
public class ClienteController {

    private final ClienteService clienteService;

    public ClienteController(ClienteService service) {
        clienteService = service;
    }

    // Listar Todos
    @GetMapping
    public ResponseEntity<List<Cliente>> listarClientes() {
        // 1. Pegar a Lista de clientes
        List<Cliente> clientes = clienteService.listarTodos();

        return ResponseEntity.ok(clientes);
    }

     @PostMapping
    public ResponseEntity<Cliente> cadastrarCliente(@RequestBody Cliente cliente) {


        cliente = clienteService.cadastrarCliente(cliente);

         // Codigo 200 - OK
//        return ResponseEntity.ok(cliente);

         // Codigo 201 - CREATED
         return ResponseEntity.status(HttpStatus.CREATED).body(cliente);
     }

     @GetMapping("/{id}")
    public ResponseEntity<?> buscarClientePorId(@PathVariable int id){
        Cliente cl = clienteService.buscarPorid(id);

        if (cl == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Cliente " + id + "não encontrado");
        }
        return ResponseEntity.ok(cl);
     }

     @DeleteMapping("/{id}")

     public ResponseEntity<?> deletarCliente(@PathVariable int id){
         Cliente cl = clienteService.deletarCliente(id);

         if (cl == null) {
             return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Cliente " + id + " Não encontrado");
         }
         return ResponseEntity.ok(cl);
     }

     @PutMapping("/{id}")
    public ResponseEntity<?> atualizarCliente(@PathVariable int id, @RequestBody Cliente clienteNovo){

        Cliente cl = clienteService.atualizarCliente(id, clienteNovo);

         if (cl == null) {
             return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Cliente Não encontrado!");
         }
         return ResponseEntity.ok(cl);

     }

}