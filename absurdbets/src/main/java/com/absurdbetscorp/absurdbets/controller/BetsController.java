package com.absurdbetscorp.absurdbets.controller;

import com.absurdbetscorp.absurdbets.entity.Bets;
import com.absurdbetscorp.absurdbets.repository.BetsRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/bets")
public class BetsController {

    private final BetsRepository betsRepository;

    public BetsController(BetsRepository betsRepository) {
        this.betsRepository = betsRepository;
    }

    @GetMapping
    public List<Bets> getAllBets() {
        return betsRepository.findAll();
    }

    @PostMapping
    public Bets createBet(@RequestBody Bets bet) {
        return betsRepository.save(bet);
    }

    @GetMapping("/{betId}")
    public Bets getBetById(@PathVariable Long betId) {
        return betsRepository.findById(betId).orElse(null);
    }

    @DeleteMapping("/{betId}")
    public void deleteBet(@PathVariable Long betId) {
        betsRepository.deleteById(betId);
    }
}
