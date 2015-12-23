package com.github.parisoft.magic.engine.condition.object;

import static com.github.parisoft.magic.engine.condition.Condition.Conjuction.AND;
import static org.apache.commons.collections4.CollectionUtils.isNotEmpty;

import com.github.parisoft.magic.engine.condition.Condition;
import com.github.parisoft.magic.engine.entity.MtgObject;
import com.github.parisoft.magic.engine.evaluator.Evaluators;

public abstract class CharacteristCondition extends Condition<MtgObject> {

    protected final String expectedValue;
    
    public CharacteristCondition() {
        this(null);
    }

    public CharacteristCondition(String expectedValue) {
        this(AND, expectedValue);
    }
    
    public CharacteristCondition(Conjuction conjuction, String expectedValue) {
        this.expectedValue = expectedValue;
        this.conjuction = conjuction;
    }
    
    
    protected Integer toInteger(String value) {
        try {
            return Integer.valueOf(value);
        } catch (Exception e) {
            return null;
        } 
    }
    
    protected int expectedInt() {
        if (isNotEmpty(evaluators)) {
            return Evaluators.evaluate(evaluators);
        }
        
        return toInteger(expectedValue);
    }
}
