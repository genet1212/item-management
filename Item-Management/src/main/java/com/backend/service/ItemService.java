package com.backend.service;

import com.backend.model.Item;
import com.backend.repository.ItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
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
