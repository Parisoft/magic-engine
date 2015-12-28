package com.github.parisoft.magic.engine.condition;

import static com.github.parisoft.magic.engine.condition.Condition.Conjuction.AND;

import java.util.Collection;

public class Conditions {

    public static <T> boolean meets(Collection<Condition<T>> conditions, T object) {
        boolean meets = true;
        
        for (Condition<T> condition : conditions) {
            if (condition.conjuction.equals(AND)) {
                meets &= condition.meets(object);
            } else {
                meets |= condition.meets(object);
            }
        }
        
        return meets;
    }
}
