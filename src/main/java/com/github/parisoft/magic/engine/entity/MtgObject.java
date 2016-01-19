package com.github.parisoft.magic.engine.entity;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.github.parisoft.magic.engine.ability.Ability;
import com.google.common.collect.FluentIterable;

@JsonIgnoreProperties(ignoreUnknown = true)
public class MtgObject {

    protected String name;
    protected String manaCost;
    protected List<String> colors;
    protected List<String> types;
    protected List<String> supertypes;
    protected List<String> subtypes;
    protected String text;
    protected String power;
    protected String toughness;
    protected String loyalty;
    protected List<Ability> abilities;
    
    protected Player owner;
    protected Player controller;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getManaCost() {
        return manaCost;
    }

    public void setManaCost(String manaCost) {
        this.manaCost = manaCost;
    }

    public List<String> getColors() {
        return colors;
    }

    public void setColors(List<String> colors) {
        this.colors = colors;
    }

    public List<String> getTypes() {
        return types;
    }

    public void setTypes(List<String> types) {
        this.types = types;
    }

    public List<String> getSupertypes() {
        return supertypes;
    }

    public void setSupertypes(List<String> supertypes) {
        this.supertypes = supertypes;
    }

    public List<String> getSubtypes() {
        return subtypes;
    }

    public void setSubtypes(List<String> subtypes) {
        this.subtypes = subtypes;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getPower() {
        return power;
    }

    public void setPower(String power) {
        this.power = power;
    }

    public String getToughness() {
        return toughness;
    }

    public void setToughness(String toughness) {
        this.toughness = toughness;
    }

    public String getLoyalty() {
        return loyalty;
    }

    public void setLoyalty(String loyalty) {
        this.loyalty = loyalty;
    }

    public <A extends Ability> List<A> getAbilities(Class<A> abilityType) {
        return FluentIterable.from(abilities).filter(abilityType).toList();
    }
    
    public List<Ability> getAbilities() {
        return abilities;
    }

    public void setAbilities(List<Ability> abilities) {
        this.abilities = abilities;
    }
    
    public Player getOwner() {
        return owner;
    }
    
    public Player getController() {
        return controller;
    }

}
