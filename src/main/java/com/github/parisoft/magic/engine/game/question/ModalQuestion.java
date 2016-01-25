package com.github.parisoft.magic.engine.game.question;

import java.util.List;

public class ModalQuestion extends Question<List<String>> {

    private final List<String> options;
    
    public ModalQuestion(String message, List<String> options) {
        super(message);
        this.options = options;
    }

    public List<String> getOptions() {
        return options;
    }
}
