package com.github.parisoft.magic.engine.interpreter;

import static org.apache.commons.lang3.StringUtils.equalsIgnoreCase;
import static org.apache.commons.lang3.StringUtils.isNotBlank;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class AbilityExpression extends Expression<String> {// TODO change to Expression<Ability> 

    private @Autowired CostExpression costExpression;
    private @Autowired EffectExpression effectExpression;

    public String interpret(Token token) {
        token.next();
        token.checkpoint();

        String ability = interpretActivatedAbility(token);

        if (isNotBlank(ability)) {
            return ability;
        }
        
        token.rewind();

        ability = interpretTriggeredAbility(token);

        if (isNotBlank(ability)) {
            return ability;
        }

        return "UnkonwAbility";
    }

    private String interpretActivatedAbility(Token token) {
        StringBuilder builder = new StringBuilder("ActivatedAbility=[");
        String singleCost;
        boolean dontHasCosts = true;
        
        while ((singleCost = costExpression.interpret(token)) != null) {
            builder.append(singleCost);
            dontHasCosts = false;

            if (equalsIgnoreCase(",", token.current())) {
                builder.append(",");
                token.next();
                continue;
            }

            break;
        }

        if (dontHasCosts) {
            return null;
        }

        if (equalsIgnoreCase(":", token.current())) {
            builder.append(":");
            token.next();
        } else {
            return null;
        }

        String effect = effectExpression.interpret(token);

        if (effect == null) {
            return null;
        }

        return builder.append(", ").append(effect).append("]").toString();
    }

    private String interpretTriggeredAbility(Token token) {
        StringBuilder builder = new StringBuilder("TriggeredAbility=[");

        String condition = interpretTriggerCondition(token);

        if (condition == null) {
            return null;
        }

        builder.append(condition);

        while (!equalsIgnoreCase(",", token.current())) {
            builder.append(token);
            token.next();
        }
        
        if (equalsIgnoreCase(",", token.current())) {
            token.next();
        }else {
            return null;
        }

        String effect = this.effectExpression.interpret(token);

        if (effect == null) {
            return null;
        }

        return builder.append(", ").append(effect).append("]").toString();
    }

    private String interpretTriggerCondition(Token token) {
        StringBuilder builder = new StringBuilder("Condition=[");
        
        if (equalsIgnoreCase("When", token.current())
                || equalsIgnoreCase("Whenever", token.current())
                || equalsIgnoreCase("At", token.current())) {
            token.next();
            return builder.append(token.current()).append("]").toString();
        }
        
        return null;
    }

}
