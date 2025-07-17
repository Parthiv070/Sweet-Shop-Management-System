package com.sweetshop.service;

import com.sweetshop.model.Sweet;
import com.sweetshop.repository.SweetRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SweetService {

    private final SweetRepository sweetRepository;
    private final SequenceGeneratorService sequenceGeneratorService;

    public SweetService(SweetRepository sweetRepository, SequenceGeneratorService sequenceGeneratorService) {
        this.sweetRepository = sweetRepository;
        this.sequenceGeneratorService = sequenceGeneratorService;
    }

    public Sweet addSweet(Sweet sweet) {
        sweet.setId(sequenceGeneratorService.getNextSequence("sweet"));  // ✅ Set custom ID
        return sweetRepository.save(sweet);
    }

    public List<Sweet> getAllSweets() {
        return sweetRepository.findAll();
    }

    public Sweet updateQuantity(long id, int quantity) {
        Sweet sweet = sweetRepository.findById(id).orElseThrow();
        sweet.setQuantity(quantity);
        return sweetRepository.save(sweet);
    }

    public void deleteSweet(long id) {
        sweetRepository.deleteById(id);
    }

    public List<Sweet> searchByName(String name) {
        return sweetRepository.findByNameContainingIgnoreCase(name);
    }

    public List<Sweet> searchByCategory(String category) {
        return sweetRepository.findByCategoryIgnoreCase(category);
    }

    public List<Sweet> searchByPriceRange(double min, double max) {
        return sweetRepository.findByPriceBetween(min, max);
    }

    public Sweet purchaseSweet(long id, int quantity) {
        Sweet sweet = sweetRepository.findById(id).orElseThrow(() -> new RuntimeException("Sweet not found"));
        if (sweet.getQuantity() < quantity) {
            throw new RuntimeException("Not enough stock available");
        }
        sweet.setQuantity(sweet.getQuantity() - quantity);
        return sweetRepository.save(sweet);
    }

    public Sweet restockSweet(long id, int quantity) {
        Sweet sweet = sweetRepository.findById(id).orElseThrow(() -> new RuntimeException("Sweet not found"));
        sweet.setQuantity(sweet.getQuantity() + quantity);
        return sweetRepository.save(sweet);
    }
}
