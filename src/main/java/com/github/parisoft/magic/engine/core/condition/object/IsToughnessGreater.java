package com.github.parisoft.magic.engine.core.condition.object;

import com.github.parisoft.magic.engine.core.entity.MtgObject;

public class IsToughnessGreater extends CharacteristCondition {

    @Override
    public boolean meets(MtgObject object) {
        Integer tou = object.getToughness();
        return tou != null && tou > expectedInt();
    }

}
