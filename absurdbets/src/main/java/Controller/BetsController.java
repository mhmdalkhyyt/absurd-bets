package Controller;

import models.Bets;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import repositories.BetsRepository;

import java.util.List;

@RestController
@RequestMapping("/api/bets")
public class BetsController {

    private final BetsRepository betsRepository;

    @Autowired
    public BetsController(BetsRepository betsRepository) {
        this.betsRepository = betsRepository;
    }

    @GetMapping("/{id}")
    public Bets getBetById(@PathVariable int id) {
        return betsRepository.getBetId(id);
    }

    @GetMapping
    public List<Bets> getAllBets() {
        return betsRepository.getAllBets();
    }

    @PostMapping
    public void createBet(@RequestBody Bets bet) {
        betsRepository.insert(bet);
    }

    @PutMapping("/{id}")
    public void updateBet(@PathVariable int id, @RequestBody Bets bet) {
        // Ensure the provided bet has the correct ID
        bet.setBetId(id);
        betsRepository.update(bet);
    }

    @DeleteMapping("/{id}")
    public void deleteBet(@PathVariable int id) {
        betsRepository.delete(id);
    }
}
