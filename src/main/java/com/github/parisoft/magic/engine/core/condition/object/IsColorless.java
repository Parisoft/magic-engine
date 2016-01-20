package com.github.parisoft.magic.engine.core.condition.object;

import static org.apache.commons.collections4.CollectionUtils.isEmpty;

import com.github.parisoft.magic.engine.core.entity.MtgObject;

public class IsColorless extends CharacteristCondition {

    @Override
    public boolean meets(MtgObject object) {
        return isEmpty(object.getColors());
    }

}
