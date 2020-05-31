package com.ismail.formula_generator.repositories;

import com.ismail.formula_generator.entities.Formula;

import java.util.List;

public interface FormulaRepository {

    public List<Formula> findAll();

    public Formula findById(String id);

    public void save(String formula);

    public void delete(String id);

    public void update(String formula, String id);
}
