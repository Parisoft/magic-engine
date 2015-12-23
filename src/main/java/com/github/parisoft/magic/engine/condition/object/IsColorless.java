package com.github.parisoft.magic.engine.condition.object;

import static org.apache.commons.collections4.CollectionUtils.isEmpty;

import com.github.parisoft.magic.engine.entity.MtgObject;

public class IsColorless extends CharacteristCondition {

    @Override
    public boolean meets(MtgObject object) {
        return isEmpty(object.getColors());
    }

}
