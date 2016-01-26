package com.github.parisoft.magic.engine.core.condition.object;

import com.github.parisoft.magic.engine.core.entity.MtgObject;

public class IsPowerLess extends CharacteristCondition {

    @Override
    public boolean meets(MtgObject object) {
        Integer pow = object.getPower();
        return pow != null && pow < expectedInt();
    }
    
}
