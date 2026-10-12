package com.example.calorie_tracker;

import java.util.List;

import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

@RestController
@RequestMapping("/api/weights")
public class WeightEntryController {

    private final WeightEntryRepository repository;

    public WeightEntryController(WeightEntryRepository repository) {
        this.repository = repository;
    }

    @GetMapping
    public List<WeightEntry> getWeights() {
        return repository.findAll(
            Sort.by(
                Sort.Order.desc("entryDate"),
                Sort.Order.desc("id")
            )
        );
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public WeightEntry saveWeight(@RequestBody WeightEntry entry) {
        Double weight = entry.getWeightKg();

        if (weight == null || !Double.isFinite(weight)
                || weight <= 0 || weight > 1000) {
            throw new ResponseStatusException(
                HttpStatus.BAD_REQUEST,
                "Enter a weight greater than 0 and up to 1000 kg."
            );
        }

        if (entry.getEntryDate() == null) {
            throw new ResponseStatusException(
                HttpStatus.BAD_REQUEST,
                "Measurement date is required."
            );
        }

        WeightEntry newEntry = new WeightEntry();
        newEntry.setWeightKg(weight);
        newEntry.setEntryDate(entry.getEntryDate());

        return repository.save(newEntry);
    }

    @DeleteMapping("/{id}")
@ResponseStatus(HttpStatus.NO_CONTENT)
public void deleteWeight(@PathVariable Long id) {

    if (!repository.existsById(id)) {
        throw new ResponseStatusException(
            HttpStatus.NOT_FOUND,
            "Weight entry not found"
        );
    }

    repository.deleteById(id);
}
@PutMapping("/{id}")
public WeightEntry updateWeight(
        @PathVariable Long id,
        @RequestBody WeightEntry updatedWeight) {

    WeightEntry existingWeight = repository.findById(id)
        .orElseThrow(() -> new ResponseStatusException(
            HttpStatus.NOT_FOUND,
            "Weight entry not found"
        ));

    if (updatedWeight.getWeightKg() == null ||
        updatedWeight.getWeightKg() <= 0 ||
        updatedWeight.getEntryDate() == null) {

        throw new ResponseStatusException(
            HttpStatus.BAD_REQUEST,
            "Please enter a valid weight and date"
        );
    }

    existingWeight.setWeightKg(updatedWeight.getWeightKg());
    existingWeight.setEntryDate(updatedWeight.getEntryDate());

    return repository.save(existingWeight);
}
}