package com.example.expensetracker.service;

import com.example.expensetracker.model.CheltuialaModel;
import com.example.expensetracker.repository.CheltuialaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CheltuialaServiceImplementare implements CheltuialaService{
    @Autowired
    private CheltuialaRepository cheltuialaRepository;

    @Override
    public List<CheltuialaModel> preiaToateCheltuielile() {
        return cheltuialaRepository.findAll();
    }

    @Override
    public void creazaCheltuiala(CheltuialaModel cheltuiala) {
        this.cheltuialaRepository.save(cheltuiala);
    }
    public CheltuialaModel preiaOCheltuiala(Integer id){
        Optional<CheltuialaModel> optional = cheltuialaRepository.findById(id);
        CheltuialaModel cheltuiala = null;
        if(optional.isPresent()){
            cheltuiala=optional.get();
        }else{
            throw new RuntimeException("Cheltuiala cu id-ul "+id+" nu a fost gasita");
        }
        return cheltuiala;

    }

    @Override
    public void stergeCheltuiala(Integer id) {
        this.cheltuialaRepository.deleteById(id);
    }
}
