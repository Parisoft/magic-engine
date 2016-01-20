package com.github.parisoft.magic.engine.core.condition.object;

import com.github.parisoft.magic.engine.core.entity.MtgObject;

public class IsNonType extends IsType {

    @Override
    public boolean meets(MtgObject object) {
        return !super.meets(object);
    }
}
