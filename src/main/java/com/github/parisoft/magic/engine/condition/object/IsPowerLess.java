package com.github.parisoft.magic.engine.condition.object;

import com.github.parisoft.magic.engine.entity.MtgObject;

public class IsPowerLess extends CharacteristCondition {

    @Override
    public boolean meets(MtgObject object) {
        Integer pow = toInteger(object.getPower());
        return pow != null && pow < toInteger(expectedValue);
    }
    
}
