package com.github.parisoft.magic.engine.game.phase;

public enum PhaseName {
    BEGINNING, MAIN, COMBAT;
    
    public String toString() {
        return super.toString().toLowerCase();
    };
}
