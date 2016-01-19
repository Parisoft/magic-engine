package com.github.parisoft.magic.engine.game.step;

public enum StepName {

    UNTAP, UPKEEP, DRAW;
    
    @Override
    public String toString() {
        return super.toString().toLowerCase();
    }
}
