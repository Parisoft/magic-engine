package com.github.parisoft.magic.engine.condition.object;

import com.github.parisoft.magic.engine.entity.MtgObject;

public class IsType extends CharacteristCondition {

    @Override
    public boolean meets(MtgObject object) {
        return object.getTypes().contains(expectedValue);
    }

}
