package com.absurdbetscorp.absurdbets.controller;

import com.absurdbetscorp.absurdbets.entity.PlaceBets;
import com.absurdbetscorp.absurdbets.repository.PlaceBetsRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/placeBets")
public class placeBetsController {

    private final PlaceBetsRepository placeBetsRepository;

    public placeBetsController(PlaceBetsRepository placeBetsRepository) {
        this.placeBetsRepository = placeBetsRepository;
    }

    @GetMapping
    public List<PlaceBets> getAllBets() {
        return placeBetsRepository.findAll();
    }

    @PostMapping ("/placeBet")
    public PlaceBets createBet(@RequestBody PlaceBets bet) {
        return placeBetsRepository.save(bet);
    }

    @GetMapping("/{placeBetId}")
    public PlaceBets getBetById(@PathVariable Long betId) {
        return placeBetsRepository.findById(betId).orElse(null);
    }

    @DeleteMapping("/{placeBetId}")
    public void deleteBet(@PathVariable Long betId) {
        placeBetsRepository.deleteById(betId);
    }
}
