package com.github.parisoft.magic.engine.condition;

import static com.github.parisoft.magic.engine.condition.Condition.Conjuction.AND;

import java.util.Collection;

import com.github.parisoft.magic.engine.condition.Condition.Conjuction;

public class Conditions {

    public static boolean meets(Collection<Condition<?>> conditions) {
        boolean meets = true;
        
        for (Condition<?> condition : conditions) {
            if (condition.conjuction.equals(AND)) {
                meets = meets && condition.meets(object);
            } else {
                meets = meets || condition.meets(object);
            }
        }
        
        return meets;
    }
}
