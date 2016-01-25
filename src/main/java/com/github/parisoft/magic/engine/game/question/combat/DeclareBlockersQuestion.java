package com.github.parisoft.magic.engine.game.question.combat;

import java.util.List;

import com.github.parisoft.magic.engine.game.question.Question;

public class DeclareBlockersQuestion extends Question<List<Block>> {

    public DeclareBlockersQuestion() {
        super("Choose the blocking creatures");
    }

}
