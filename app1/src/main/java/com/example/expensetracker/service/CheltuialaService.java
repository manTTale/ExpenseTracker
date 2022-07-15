package com.example.expensetracker.service;

import com.example.expensetracker.model.CheltuialaModel;
import java.util.List;

public interface CheltuialaService {
    List<CheltuialaModel> preiaToateCheltuielile();
    void creazaCheltuiala(CheltuialaModel cheltuiala);
    CheltuialaModel preiaOCheltuiala(Integer id);
    void stergeCheltuiala(Integer id);
}
