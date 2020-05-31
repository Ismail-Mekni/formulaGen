package com.ismail.formula_generator.service.impl;

import com.ismail.formula_generator.entities.Formula;
import com.ismail.formula_generator.entities.ValidationResult;
import com.ismail.formula_generator.repositories.FormulaRepository;
import com.ismail.formula_generator.service.FormulaService;
import org.mariuszgromada.math.mxparser.Expression;
import org.mariuszgromada.math.mxparser.Function;

import java.util.List;

public class FormulaServiceImpl implements FormulaService {

    private FormulaRepository formulaRepository;

    public FormulaServiceImpl(FormulaRepository formulaRepository) {
        this.formulaRepository = formulaRepository;
    }

    public List<Formula> getHistory() {
        return formulaRepository.findAll();
    }

    public Formula getFormula(String id) {
        return formulaRepository.findById(id);
    }

    public void saveFormula(String formula) {
        formulaRepository.save(formula);
    }

    public void updateFormula(String formula, String id) {
        formulaRepository.update(formula, id);
    }

    public void deleteFormula(String id) {
        formulaRepository.delete(id);
    }

    public ValidationResult checkFormula(String function) {
        ValidationResult result = new ValidationResult();
        Function f = new Function(function);
        result.setValid(f.checkSyntax());
        result.setMessage(f.getErrorMessage());
        return result;
    }

    public String calculateExpression(String function, String expression) {
        Function f = new Function(function);
        Expression e = new Expression(expression, f);
        return String.valueOf(e.calculate());
    }
}
