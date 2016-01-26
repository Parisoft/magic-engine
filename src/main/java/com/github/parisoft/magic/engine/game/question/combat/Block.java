package com.github.parisoft.magic.engine.game.question.combat;

import com.github.parisoft.magic.engine.core.entity.Entity;

public class Block {

    private Entity blocker;
    private Entity blocked;

    public Block() {
        super();
    }

    public Block(Entity blocker, Entity blocked) {
        this.blocker = blocker;
        this.blocked = blocked;
    }

    public Entity getBlocker() {
        return blocker;
    }

    public void setBlocker(Entity blocker) {
        this.blocker = blocker;
    }

    public Entity getBlocked() {
        return blocked;
    }

    public void setBlocked(Entity blocked) {
        this.blocked = blocked;
    }

}
