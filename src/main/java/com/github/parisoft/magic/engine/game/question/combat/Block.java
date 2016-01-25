package com.github.parisoft.magic.engine.game.question.combat;

public class Block {

    private Object blocker;
    private Object blocked;

    public Block() {
        super();
    }

    public Block(Object blocker, Object blocked) {
        this.blocker = blocker;
        this.blocked = blocked;
    }

    public Object getBlocker() {
        return blocker;
    }

    public void setBlocker(Object blocker) {
        this.blocker = blocker;
    }

    public Object getBlocked() {
        return blocked;
    }

    public void setBlocked(Object blocked) {
        this.blocked = blocked;
    }

}
