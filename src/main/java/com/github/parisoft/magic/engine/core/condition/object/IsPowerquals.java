package com.github.parisoft.magic.engine.core.condition.object;

import com.github.parisoft.magic.engine.core.entity.MtgObject;

public class IsPowerquals extends CharacteristCondition {

    @Override
    public boolean meets(MtgObject object) {
        Integer pow = toInteger(object.getPower());
        return pow != null && pow == expectedInt();
    }

}
