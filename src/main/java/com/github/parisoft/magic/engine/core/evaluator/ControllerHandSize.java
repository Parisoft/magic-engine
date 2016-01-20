package com.github.parisoft.magic.engine.core.evaluator;

import com.github.parisoft.magic.engine.core.entity.MtgObject;

public class ControllerHandSize extends Evaluator {

    private final MtgObject object;
    
    public ControllerHandSize(MtgObject object) {
        this.object = object;
    }

    @Override
    public int evaluate() {
        return object.getController().getHand().size();
    }

}
