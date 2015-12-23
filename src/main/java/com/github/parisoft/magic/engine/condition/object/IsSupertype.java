package com.github.parisoft.magic.engine.condition.object;

import com.github.parisoft.magic.engine.entity.MtgObject;

public class IsSupertype extends CharacteristCondition {

    @Override
    public boolean meets(MtgObject object) {
        return object.getSubtypes().contains(expectedValue);
    }

}
