package com.example.expensetracker.repository;

import com.example.expensetracker.model.CheltuialaModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CheltuialaRepository extends JpaRepository<CheltuialaModel, Integer> {
}
