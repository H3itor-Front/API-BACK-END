package br.com.ecommerce.api.service;

import br.com.ecommerce.api.model.Cliente;
import br.com.ecommerce.api.repository.ItemRepository;
import br.com.ecommerce.api.model.Item;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ItemService {
    // Injecao de Dependencia
    // Falar que Service Depende de alguém
    private final ItemRepository itemRepository;

    public ItemService(ItemRepository repo3) {
        this.itemRepository = repo3;
    }

    public List<Item> listarTodos() {

        return itemRepository.findAll();
    }
    public Item cadastrarItem(Item it) {
        return itemRepository.save(it);
    }

    public Item buscarPorid(int id){

        return itemRepository.findById(id).orElse(null);
    }
    public Item deletarItem(int id) {
        Item it = buscarPorid(id);
        if (it == null) {
            return null;
        }
        itemRepository.delete(it);
        return it;
    }
}

