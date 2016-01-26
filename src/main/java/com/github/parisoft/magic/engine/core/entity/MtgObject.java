package com.github.parisoft.magic.engine.core.entity;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.github.parisoft.magic.engine.core.ability.Ability;
import com.github.parisoft.magic.engine.game.oracle.PowTouDeserializer;
import com.google.common.collect.FluentIterable;

@JsonIgnoreProperties(ignoreUnknown=true)
public class MtgObject extends Entity {

    protected String name;
    protected String manaCost;
    protected List<String> colors;
    protected List<String> types;
    protected List<String> supertypes;
    protected List<String> subtypes;
    protected String text;
    protected Integer power;
    protected Integer toughness;
    protected String loyalty;
    protected List<Ability> abilities;

    @JsonIgnore
    protected Player owner;
    
    @JsonIgnore
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

    public Integer getToughness() {
        return toughness;
    }

    @JsonDeserialize(converter=PowTouDeserializer.class)
    public void setToughness(Integer toughness) {
        this.toughness = toughness;
    }
    
    public Integer getPower() {
        return power;
    }

    @JsonDeserialize(converter=PowTouDeserializer.class)
    public void setPower(Integer power) {
        this.power = power;
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

    public void setOwner(Player owner) {
        this.owner = owner;
    }

    public Player getController() {
        return controller;
    }

    public void setController(Player controller) {
        this.controller = controller;
    }

}
