package com.ismail.formula_generator.mock;

import com.ismail.formula_generator.entities.Formula;
import com.ismail.formula_generator.repositories.FormulaRepository;

import java.util.Arrays;
import java.util.List;

public class MockFormulaRepository implements FormulaRepository {
    public List<Formula> findAll() {
        Formula f0 = new Formula("0", "f(x,y)=sin(x) + cos(y)");
        Formula f1 = new Formula("1", "f(x,y)=sin(x) + cos(y) + 1");
        Formula f2 = new Formula("2", "f(x,y)=sin(x) + cos(y) + 2");
        Formula f3 = new Formula("3", "f(x,y)=sin(x) + cos(y) + 3");
        return Arrays.asList(f0, f1, f2, f3);
    }

    public Formula findById(String id) {
        return new Formula(id, "f(x,y)=sin(x) + cos(y)");
    }

    public void save(String formula) {
        System.out.println("Formula: " + formula + " Saved");
    }

    public void delete(String id) {
        System.out.println("Formula with id: " + id + " Deleted");
    }

    public void update(String formula, String id) {
        System.out.println("Formula: " + formula + " With id: " + id + " Upadated");
    }
}
