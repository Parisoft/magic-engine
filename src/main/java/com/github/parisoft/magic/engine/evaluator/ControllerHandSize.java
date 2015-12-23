package com.github.parisoft.magic.engine.evaluator;

import com.github.parisoft.magic.engine.entity.MtgObject;

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
