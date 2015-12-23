package com.github.parisoft.magic.engine.condition.object;

import com.github.parisoft.magic.engine.condition.Condition;
import com.github.parisoft.magic.engine.entity.MtgObject;

public abstract class CharacteristCondition extends Condition<MtgObject> {

    protected final String expectedValue;
    
    public CharacteristCondition(String expectedValue) {
        this.expectedValue = expectedValue;
    }
    
    public CharacteristCondition() {
        this(null);
    }
    
    protected Integer toInteger(String value) {
        try {
            return Integer.valueOf(value);
        } catch (Exception e) {
            return null;
        } 
    }
}
