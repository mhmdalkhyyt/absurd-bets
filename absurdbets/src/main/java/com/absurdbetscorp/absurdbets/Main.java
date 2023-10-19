package com.absurdbetscorp.absurdbets;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@SpringBootApplication
@RestController
@RequestMapping("/api/bets")
public class Main {

    private final BetsRepository betsRepository;

    public Main(BetsRepository betsRepository) {
        this.betsRepository = betsRepository;
    }

    public static void main(String[] args) {
        SpringApplication.run(Main.class, args);
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
