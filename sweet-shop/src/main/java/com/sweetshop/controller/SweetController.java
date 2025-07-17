package com.sweetshop.controller;

import com.sweetshop.model.Sweet;
import com.sweetshop.service.SweetService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api/sweets")
public class SweetController {

    private final SweetService sweetService;

    public SweetController(SweetService sweetService) {
        this.sweetService = sweetService;
    }

    @PostMapping
    public Sweet addSweet(@RequestBody Sweet sweet) {
        return sweetService.addSweet(sweet);
    }

    @GetMapping
    public List<Sweet> getAllSweets() {
        return sweetService.getAllSweets();
    }
    // Final: Search Feature
    @GetMapping("/search")
    public List<Sweet> searchSweets(
            @RequestParam(required = false) String name,
            @RequestParam(required = false) String category,
            @RequestParam(required = false) Double minPrice,
            @RequestParam(required = false) Double maxPrice
    ) {
        List<Sweet> sweets = sweetService.getAllSweets();

        if (name != null) {
            sweets = sweets.stream()
                    .filter(s -> s.getName().toLowerCase().contains(name.toLowerCase()))
                    .toList();
        }
        if (category != null) {
            sweets = sweets.stream()
                    .filter(s -> s.getCategory().equalsIgnoreCase(category))
                    .toList();
        }
        if (minPrice != null && maxPrice != null) {
            sweets = sweets.stream()
                    .filter(s -> s.getPrice() >= minPrice && s.getPrice() <= maxPrice)
                    .toList();
        }

        return sweets;
    }

    @PutMapping("/{id}")
    public Sweet updateSweet(@PathVariable long id, @RequestParam int quantity) {
        return sweetService.updateQuantity(id, quantity);
    }

    @DeleteMapping("/{id}")
    public void deleteSweet(@PathVariable long id) {
        sweetService.deleteSweet(id);
    }

    @PutMapping("/{id}/purchase")
    public Sweet purchaseSweet(@PathVariable long id, @RequestParam int quantity) {
        return sweetService.purchaseSweet(id, quantity);
    }

    @PutMapping("/{id}/restock")
    public Sweet restockSweet(@PathVariable long id, @RequestParam int quantity) {
        return sweetService.restockSweet(id, quantity);
    }

}
