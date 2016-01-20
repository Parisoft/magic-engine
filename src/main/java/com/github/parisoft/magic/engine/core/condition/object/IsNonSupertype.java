package com.github.parisoft.magic.engine.core.condition.object;

import com.github.parisoft.magic.engine.core.entity.MtgObject;

public class IsNonSupertype extends IsSupertype {

    @Override
    public boolean meets(MtgObject object) {
        return !super.meets(object);
    }
}
