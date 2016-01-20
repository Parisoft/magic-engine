package com.github.parisoft.magic.engine.core.entity;

public class Card extends MtgObject {

    private boolean tapped = false;
    private boolean phased = false;

    public boolean isTapped() {
        return tapped;
    }

    public void setTapped(boolean tapped) {
        this.tapped = tapped;
    }

    public boolean isPhased() {
        return phased;
    }

    public void setPhased(boolean phased) {
        this.phased = phased;
    }

}
