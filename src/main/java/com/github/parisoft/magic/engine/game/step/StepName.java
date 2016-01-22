package com.github.parisoft.magic.engine.game.step;

public enum StepName {

    UNTAP, UPKEEP, DRAW, BEGINNING_OF_COMBAT, DECLARE_ATTACKERS;
    
    @Override
    public String toString() {
        return super.toString().toLowerCase().replace('_', ' ');
    }
}
