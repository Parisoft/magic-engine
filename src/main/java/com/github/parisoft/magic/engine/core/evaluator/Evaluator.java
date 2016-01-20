package com.github.parisoft.magic.engine.core.evaluator;

import static com.github.parisoft.magic.engine.core.evaluator.Evaluator.Operation.PLUS;

public abstract class Evaluator {

    public enum Operation {
        PLUS, MINUS
    }
    
    protected Operation operation = PLUS;
    
    public abstract int evaluate();
    
    public Operation getOperation() {
        return operation;
    }
    
    public void setOperation(Operation operation) {
        this.operation = operation;
    }
}
