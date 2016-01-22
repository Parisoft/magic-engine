package com.github.parisoft.magic.engine.core.event;

public abstract class Event {

    protected boolean legal;
    protected boolean replaced;

    public abstract void perform();

    public boolean isIllegal() {
        return !legal;
    }

    public boolean isLegal() {
        return legal;
    }

    public void setLegal(boolean legal) {
        this.legal = legal;
    }

    public boolean isReplaced() {
        return replaced;
    }

    public void setReplaced(boolean replaced) {
        this.replaced = replaced;
    }

}
