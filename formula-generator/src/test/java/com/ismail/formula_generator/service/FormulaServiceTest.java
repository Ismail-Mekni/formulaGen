package com.ismail.formula_generator.service;

import com.ismail.formula_generator.entities.Formula;
import com.ismail.formula_generator.entities.ValidationResult;
import com.ismail.formula_generator.mock.MockFormulaRepository;
import com.ismail.formula_generator.service.impl.FormulaServiceImpl;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

public class FormulaServiceTest {

    FormulaService formulaService;

    @Before
    public void setUp(){
        formulaService= new FormulaServiceImpl(new MockFormulaRepository());
    }

    @Test
    public void getHistoryTest(){
        List<Formula> formulas=formulaService.getHistory();

        Assert.assertEquals(formulas.size(), 4);
    }

    @Test
    public void getFormulaTest(){
        Formula formula=formulaService.getFormula("1");

        Assert.assertNotNull(formula);
        Assert.assertEquals(formula.getId(), "1");
        Assert.assertEquals(formula.getFormula(), "f(x,y)=sin(x) + cos(y)");
    }

    @Test
    public void saveFormulaTest(){
        formulaService.saveFormula("f(x,y)=sin(x) + cos(y)");
    }

    @Test
    public void updateFormulaTest(){
        formulaService.updateFormula("f(x,y)=sin(x) + cos(y)", "1");
    }

    @Test
    public void deleteFormulaTest(){
        formulaService.deleteFormula("1");
    }

    @Test
    public void checkFormulaTest(){
        ValidationResult validationResult=formulaService.checkFormula("f(x,y)=x+y+1+cos(x)");

        Assert.assertEquals(validationResult.isValid(), true);
        Assert.assertTrue(validationResult.getMessage().contains("no errors"));

        validationResult=formulaService.checkFormula("f(x,y)=x+y+1+co(x)");
        Assert.assertFalse(validationResult.isValid());
        Assert.assertTrue(validationResult.getMessage().contains("errors were found"));
    }

    @Test
    public void calculateExpressionTest(){
        String result=formulaService.calculateExpression("f(x,y)=x+1+y", "f(1,2)");

        Assert.assertEquals(result, "4.0");
    }
}
