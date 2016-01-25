package com.github.parisoft.magic.engine.core.entity;

import java.util.ArrayList;
import java.util.List;

public class Card extends MtgObject {

    private boolean tapped = false;
    private boolean phased = false;
    private List<Card> blockedBy = new ArrayList<>();
    
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
    
    public List<Card> getBlockedBy() {
        return blockedBy;
    }
    
}
