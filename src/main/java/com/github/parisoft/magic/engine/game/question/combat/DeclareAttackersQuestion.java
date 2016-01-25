package com.github.parisoft.magic.engine.game.question.combat;

import java.util.List;

import com.github.parisoft.magic.engine.game.question.Question;

public class DeclareAttackersQuestion extends Question<List<Attack>> {

    public DeclareAttackersQuestion() {
        super("Choose the creatures you wish to attack");
    }

}
