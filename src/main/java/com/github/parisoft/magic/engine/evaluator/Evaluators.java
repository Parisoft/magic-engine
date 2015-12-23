package com.github.parisoft.magic.engine.evaluator;

import static com.github.parisoft.magic.engine.evaluator.Evaluator.Operation.PLUS;

import java.util.Collection;

public class Evaluators {

    public static int evaluate(Collection<Evaluator> evaluators) {
        int value = 0;
        
        for (Evaluator evaluator : evaluators) {
            if (evaluator.getOperation().equals(PLUS)) {
                value += evaluator.evaluate();
            } else {
                value -= evaluator.evaluate();
            }
        }
        
        return value;
    }
}
