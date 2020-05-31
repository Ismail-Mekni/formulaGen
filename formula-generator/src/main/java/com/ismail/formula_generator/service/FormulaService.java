package com.ismail.formula_generator.service;

import com.ismail.formula_generator.entities.Formula;
import com.ismail.formula_generator.entities.ValidationResult;

import java.util.List;

public interface FormulaService {

    public List<Formula> getHistory();

    public Formula getFormula(String id);

    public void saveFormula(String formula);

    public void updateFormula(String formula, String id);

    public void deleteFormula(String id);

    public ValidationResult checkFormula(String function);

    public String calculateExpression(String function, String expression);
}
