package com.github.parisoft.magic.engine.game.question.combat;

public class Attack {

    private Object attacker;
    private Object attacked;

    public Attack() {
        super();
    }    

    public Attack(Object attacker, Object attacked) {
        this.attacker = attacker;
        this.attacked = attacked;
    }

    public Object getAttacker() {
        return attacker;
    }

    public void setAttacker(Object attacker) {
        this.attacker = attacker;
    }

    public Object getAttacked() {
        return attacked;
    }

    public void setAttacked(Object attacked) {
        this.attacked = attacked;
    }

}
