package com.github.parisoft.magic.engine.core.entity;

public class Card extends MtgObject {

    private boolean tapped = false;
    private boolean phased = false;
    private boolean attacking = false;
    private Card blockedBy;

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

    public boolean isAttacking() {
        return attacking;
    }

    public void setAttacking(boolean attacking) {
        this.attacking = attacking;
    }

    public Card getBlockedBy() {
        return blockedBy;
    }

    public void setBlockedBy(Card blockedBy) {
        this.blockedBy = blockedBy;
    }
    
}
