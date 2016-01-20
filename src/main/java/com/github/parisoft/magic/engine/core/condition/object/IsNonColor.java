package com.github.parisoft.magic.engine.core.condition.object;

import com.github.parisoft.magic.engine.core.entity.MtgObject;

public class IsNonColor extends IsColor {

    @Override
    public boolean meets(MtgObject object) {
        return !super.meets(object);
    }
}
