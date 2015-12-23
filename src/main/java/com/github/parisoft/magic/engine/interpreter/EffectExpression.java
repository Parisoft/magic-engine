package com.github.parisoft.magic.engine.interpreter;

import org.springframework.stereotype.Component;

@Component
public class EffectExpression extends Expression<String> {

    public String interpret(Token token) {
        StringBuilder effect = new StringBuilder("Effect=[");
        
        while (token.current() != null) {
            effect.append(token.current());
            token.next();
        }
        
        return effect.append("]").toString();
    }
}
