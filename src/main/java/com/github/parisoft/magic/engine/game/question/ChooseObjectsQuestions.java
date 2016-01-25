package com.github.parisoft.magic.engine.game.question;

import java.util.List;

public class ChooseObjectsQuestions extends Question<List<Object>> {

    private int number;
    
    public ChooseObjectsQuestions(String message) {
        this(message, 1);
    }

    public ChooseObjectsQuestions(String message, int number) {
        super(message);
        this.number = number;
    }
    
    public int getNumber() {
        return number;
    }
    
    public void setNumber(int number) {
        this.number = number;
    }
}
