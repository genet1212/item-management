
package com.backend.service;

import com.backend.model.Item;
import com.backend.repository.ItemRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ItemServiceImpl implements ItemService {

    @Autowired
    private ItemRepository itemRepository;

    @Override
    public List<Item> getItems() {
        List<Item> itm = new ArrayList<>();
        itm = itemRepository.findAll();
        System.out.println("itm: " + itm.toString());
        return itm;
    }

    @Override
    public List<Item> getItem() {
        return List.of();
    }

    @Override
    public Optional<Item> getById(Long id) {
        return itemRepository.findById(id);
    }

    @Override
    public Item createItem(Item item) {
//        Get Category
//        Set Category to item
//        save
        return itemRepository.save(item);
    }

    @Override
    public Item getItem(Long id) {
        return itemRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("Item with an id: " + id + "was not found"));
    }

    @Override
    public Item updateItem(Item item) {
        //Item existingItem = itemRepository.findById(id).get();
        // BeanUtils.copyProperties(item, existingItem, getNullPropertyNames(item));
        return itemRepository.save(item);
    }

    @Override
    public Optional<Item> deleteItem(Long id) {
        return itemRepository.findById(id);
    }

}
