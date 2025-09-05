package br.com.ecommerce.api.service;

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

}
