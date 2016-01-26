package com.github.parisoft.magic.engine.game.question.combat;

import com.github.parisoft.magic.engine.core.entity.Entity;

public class Attack {

    private Entity attacker;
    private Entity attacked;

    public Attack() {
        super();
    }    

    public Attack(Entity attacker, Entity attacked) {
        this.attacker = attacker;
        this.attacked = attacked;
    }

    public Entity getAttacker() {
        return attacker;
    }

    public void setAttacker(Entity attacker) {
        this.attacker = attacker;
    }

    public Entity getAttacked() {
        return attacked;
    }

    public void setAttacked(Entity attacked) {
        this.attacked = attacked;
    }

}
