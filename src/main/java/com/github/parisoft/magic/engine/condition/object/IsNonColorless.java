package com.github.parisoft.magic.engine.condition.object;

import com.github.parisoft.magic.engine.entity.MtgObject;

public class IsNonColorless extends IsColorless {

    @Override
    public boolean meets(MtgObject object) {
        return !super.meets(object);
    }
}
