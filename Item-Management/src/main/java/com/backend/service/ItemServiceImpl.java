package com.backend.service;

import com.backend.model.Item;
import com.backend.repository.ItemRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static com.backend.utils.Utils.getNullPropertyNames;

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
        return itemRepository.save(item);
    }

    @Override
    public Item getItem(Long id) {
        return itemRepository.findById(id).orElseThrow(()-> new EntityNotFoundException("Item with an id: " + id + "was not found"));
    }

    @Override
    public Item updateItem(Long id, Item item) {
        Item existingItem = itemRepository.findById(id).get();
        BeanUtils.copyProperties(item, existingItem, getNullPropertyNames(item));
        return itemRepository.save(existingItem);
    }

    @Override
    public Item deleteItem(Long id, Item item) {
        return itemRepository.save(item);
    }

}
