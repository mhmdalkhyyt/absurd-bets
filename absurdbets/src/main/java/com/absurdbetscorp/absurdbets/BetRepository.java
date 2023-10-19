package com.absurdbetscorp.absurdbets;

import com.absurdbetscorp.absurdbets.BetsController;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface BetRepository extends JpaRepository<BetsController, Long> {
    List<BetsController> findAllByUserId(String userId);
}