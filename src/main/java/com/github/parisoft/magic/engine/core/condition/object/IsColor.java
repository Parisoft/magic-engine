package com.github.parisoft.magic.engine.core.condition.object;

import com.github.parisoft.magic.engine.core.entity.MtgObject;

public class IsColor extends CharacteristCondition {

    @Override
    public boolean meets(MtgObject object) {
        return object.getColors().contains(expectedValue);
    }

}
