package com.github.parisoft.magic.engine.interpreter;

import static org.apache.commons.lang3.StringUtils.SPACE;
import static org.apache.commons.lang3.StringUtils.equalsIgnoreCase;
import static org.apache.commons.lang3.StringUtils.isBlank;
import static org.apache.commons.lang3.StringUtils.isNotBlank;
import static org.apache.commons.lang3.StringUtils.isNumeric;
import static org.apache.commons.lang3.StringUtils.substringBetween;

import org.springframework.stereotype.Component;

@Component
public class CostExpression extends Expression<String> {

    public String interpret(Token token) {
        token.checkpoint();
        
        String cost = interpretTapCost(token);
        
        if (isNotBlank(cost)) {
            return cost;
        }
        
        token.rewind();
        cost = interpretManaCost(token);
        
        if (isNotBlank(cost)) {
            return cost;
        }
        
        token.rewind();
        cost = interpretSacrificeCost(token);
        
        if (isNotBlank(cost)) {
            return cost;
        }
        
        token.rewind();
        
        return null;
    }
    
    private String interpretTapCost(Token token) {
        if (equalsIgnoreCase("{T}", token.current())) {
            token.next();
            return "TapCost";
        }
        
        return null;
    }
    
    private String interpretManaCost(Token token) {
        StringBuilder builder = new StringBuilder("ManaCost=[");
        
        if (equalsIgnoreCase("{X}", token.current())) {
            builder.append(token.current());
            token.next();
        }

        if (isColorless(token.current())) {
            builder.append(token.current());
            token.next();
        }
        
        String symbol;
        boolean dontHasSymbol = true;
        
        while ((symbol = interpretManaSymbol(token)) != null) {
             builder.append(symbol);
             dontHasSymbol = false;
        }
        
        if (dontHasSymbol) {
            return null;
        }
        
        return builder.append("]").toString();
    }
    
    private String interpretManaSymbol(Token token) {
        if (equalsIgnoreCase("{U}", token.current())
                || equalsIgnoreCase("{B}", token.current())
                || equalsIgnoreCase("{W}", token.current())
                || equalsIgnoreCase("{R}", token.current())
                || equalsIgnoreCase("{G}", token.current())) {
            token.next();
            return token.current();
        }
        
        return null;
    }
    
    private String interpretSacrificeCost(Token token) {
        StringBuilder builder = new StringBuilder();
        
        if (equalsIgnoreCase("Sacrifice", token.current())) {
            builder.append(token.current());
            token.next();
        } else {
            return null;
        }
        
        if (equalsIgnoreCase("THIS", token.current())) {
            builder.append(SPACE).append("THIS");
            return builder.toString();
        }
        
        String permanents = interpretSacrificePermanents(token);
        
        if (isNotBlank(permanents)) {
            builder.append(permanents);
            return builder.toString();
        }
        
        return null;
    }
    
    private String interpretSacrificePermanents(Token token) {
        StringBuilder builder = new StringBuilder();
        
        if (equalsIgnoreCase("a", token.current())
                || equalsIgnoreCase("two", token.current())
                || equalsIgnoreCase("three", token.current())
                || equalsIgnoreCase("all", token.current())) {
            builder.append(token);
            token.next();
        } else {
            return null;
        }
        
        String permanent = interpretPermanent(token);
        
        if (isBlank(permanent)) {
            return null;
        }
        
        return builder.append(" ").append(permanent).toString();
    }
    
    private String interpretPermanent(Token token) {
        StringBuilder builder = new StringBuilder();
        
        if (equalsIgnoreCase("basic", token.current())
                || equalsIgnoreCase("non basic", token.current())) {
            builder.append(token);
            token.next();
        }
        
        if (equalsIgnoreCase("land", token.current())
                || equalsIgnoreCase("lands", token.current())
                || equalsIgnoreCase("mountain", token.current())
                || equalsIgnoreCase("mountains", token.current())
                || equalsIgnoreCase("forest", token.current())
                || equalsIgnoreCase("forests", token.current())
                || equalsIgnoreCase("island", token.current())
                || equalsIgnoreCase("islands", token.current())
                || equalsIgnoreCase("swamp", token.current())
                || equalsIgnoreCase("swamps", token.current())
                || equalsIgnoreCase("plains", token.current())) {
            builder.append(token);
            token.next();
        } else {
            return null;
        }
        
        return builder.toString();
    }
    
    private boolean isColorless(String cost) {
        return isNumeric(substringBetween(cost, "{", "}"));
    }
}
