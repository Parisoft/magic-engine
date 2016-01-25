package com.github.parisoft.magic.engine.game.question;

public abstract class Question<T> {

    protected String message;
    protected T answer;

    public Question(String message) {
        this.message = message;
    }
    
    public String getMessage() {
        return message;
    }
    
    public void setMessage(String message) {
        this.message = message;
    }
    
    public T getAnswer() {
        return answer;
    }
    
    public void setAnswer(T answer) {
        this.answer = answer;
    }
}
