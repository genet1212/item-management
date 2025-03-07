package com.backend.controller;

import com.backend.model.Category;
import com.backend.model.Item;
import com.backend.repository.CategoryRepository;
import com.backend.repository.ItemRepository;
import com.backend.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1/items")
@CrossOrigin(origins = "http://localhost:4200")   // Adjust for Angular's port
public class ItemController {

    @Autowired
     ItemRepository itemRepository;
    @Autowired
     CategoryRepository categoryRepository;
    @Autowired
    ItemService itemService;

    @GetMapping
    public ResponseEntity<List<Item>> getAllItems() {
        List<Item> items = itemRepository.findAll();
        return ResponseEntity.ok(items);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Item> getItemById(@PathVariable Long id) {
        return itemRepository.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<Item> createItem(@RequestBody Item newItem) {
        if (newItem == null) {
            return ResponseEntity.badRequest().build();
        }
        Item savedItem = itemRepository.save(newItem);
        return ResponseEntity.ok(savedItem);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Item> updateItem(@PathVariable Long id, @RequestBody Item updatedItem) {
        return itemRepository.findById(id)
                .map(existingItem -> {
                    existingItem.setName(updatedItem.getName());
                    existingItem.setPrice(updatedItem.getPrice());
                    existingItem.setQuantity(updatedItem.getQuantity());
                    existingItem.setDescription(updatedItem.getDescription());
                    existingItem.setExpiration_date(updatedItem.getExpiration_date());
                    Item savedItem = itemRepository.save(existingItem);
                    return ResponseEntity.ok(savedItem);
                })
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteItem(@PathVariable Long id) {
        if (itemRepository.existsById(id)) {
            itemRepository.deleteById(id);
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.notFound().build();
    }

//
//    @GetMapping("/expiring")
//    public List<Item> getExpiringProducts() {
//        return itemService.findExpiredProducts();
//    }


//
//    @PatchMapping("/{id}")
//    public ResponseEntity<Item> patchItem(@PathVariable Long id, @RequestBody Item partialItem) {
//        return itemRepository.findById(id)
//                .map(existingItem -> {
//                    if (partialItem.getName() != null) {
//                        existingItem.setName(partialItem.getName());
//                    }
//                    if (partialItem.getPrice() != null) {
//                        existingItem.setPrice(partialItem.getPrice());
//                    }
//                    if (partialItem.getQuantity() != null) {
//                        existingItem.setQuantity(partialItem.getQuantity());
//                    }
//                    if (partialItem.getDescription() != null) {
//                        existingItem.setDescription(partialItem.getDescription());
//                    }
//                      if (partialItem.getExpiration_date() != null) {
//                        existingItem.setExpiration_date(partialItem.getExpiration_date());
//                    }
//                    Item savedItem = itemRepository.save(existingItem);
//                    return ResponseEntity.ok(savedItem);
//                })
//                .orElse(ResponseEntity.notFound().build());
//    }

}
 