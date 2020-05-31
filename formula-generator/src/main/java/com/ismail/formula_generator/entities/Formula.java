package com.ismail.formula_generator.entities;

public class Formula {

    private String id;
    private String formula;

    public Formula(String id, String formula) {
        this.id = id;
        this.formula = formula;
    }

    public Formula() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getFormula() {
        return formula;
    }

    public void setFormula(String formula) {
        this.formula = formula;
    }
}
