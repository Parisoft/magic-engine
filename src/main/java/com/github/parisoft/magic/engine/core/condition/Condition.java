package com.github.parisoft.magic.engine.core.condition;

import static com.github.parisoft.magic.engine.core.condition.Condition.Conjuction.AND;

import java.util.ArrayList;
import java.util.List;

import com.github.parisoft.magic.engine.core.evaluator.Evaluator;

public abstract class Condition<T> {

    public enum Conjuction {
        AND, OR
    }

    protected Conjuction conjuction = AND;
    protected List<Evaluator> evaluators = new ArrayList<>();
    
    public abstract boolean meets(T object);
    
    public Conjuction getConjuction() {
        return conjuction;
    }
    
    public void setConjuction(Conjuction conjuction) {
        this.conjuction = conjuction;
    }
    
    public List<Evaluator> getEvaluators() {
        return evaluators;
    }
    
    public void setEvaluators(List<Evaluator> evaluators) {
        this.evaluators = evaluators;
    }
}
