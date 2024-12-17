package com.backend.service;

import com.backend.model.Item;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public interface ItemService {

    List<Item> getItems();

    List<Item> getItem();
    Optional<Item> getById(Long id);
    Item createItem(Item item);
    Item getItem(Long id);
    Item updateItem(Item item);
    Optional<Item> deleteItem(Long id);
}