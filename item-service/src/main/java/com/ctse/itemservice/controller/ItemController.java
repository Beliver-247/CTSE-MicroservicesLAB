package com.ctse.itemservice.controller;

import com.ctse.itemservice.model.Item;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

@RestController
@RequestMapping("/items")
public class ItemController {

    private final List<Item> items = new ArrayList<>();
    private final AtomicLong counter = new AtomicLong(3);

    public ItemController() {
        items.add(new Item(1L, "Book"));
        items.add(new Item(2L, "Laptop"));
        items.add(new Item(3L, "Phone"));
    }

    @GetMapping
    public ResponseEntity<List<Item>> getAllItems() {
        return ResponseEntity.ok(items);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Item> getItemById(@PathVariable Long id) {
        return items.stream()
                .filter(item -> item.getId().equals(id))
                .findFirst()
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<Item> createItem(@RequestBody Item item) {
        item.setId(counter.incrementAndGet());
        items.add(item);
        return ResponseEntity.status(HttpStatus.CREATED).body(item);
    }
}
