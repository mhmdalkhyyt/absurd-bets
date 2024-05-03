package com.absurdbetscorp.absurdbets.repository;

import com.absurdbetscorp.absurdbets.entity.Bets;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BetsRepository extends JpaRepository<Bets, Long> {
}
