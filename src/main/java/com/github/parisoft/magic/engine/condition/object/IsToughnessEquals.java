package com.github.parisoft.magic.engine.condition.object;

import com.github.parisoft.magic.engine.entity.MtgObject;

public class IsToughnessEquals extends CharacteristCondition {

    @Override
    public boolean meets(MtgObject object) {
        Integer tou = toInteger(object.getToughness());
        return tou != null && tou == toInteger(expectedValue);
    }

}
