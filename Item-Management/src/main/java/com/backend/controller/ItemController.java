package com.backend.controller;

import com.backend.model.Item;
import com.backend.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1/items")
public class ItemController {

    @Autowired
    private ItemService itemService;

    @GetMapping
    public List<Item> getItem(){
        return itemService.getItem();
    }

    @GetMapping("/query")
    public Optional<Item> getItemById(@RequestParam(name = "id")Long id){
      return itemService.getById(id);
    }

    @PostMapping
    public Item createItem(@RequestBody Item item){
        return itemService.createItem(item);
    }

    @PutMapping("{id}")
    public Item updateItem(@PathVariable(name="id") Long id, @RequestBody Item item) {
       return itemService.updateItem(id, item);
    }
    @DeleteMapping("{id}")
    public Item deleteItem(@PathVariable("id") Long id, @RequestBody Item item){
        return itemService.deleteItem(id, item);
    }

}
