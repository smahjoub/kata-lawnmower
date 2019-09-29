package com.mowitnow.lawnowner.models;

public enum Direction {
    N("N"),
    S("S"),
    E("E"),
    W("W");

    private String id;

    Direction(String id){
        this.id = id;
    }

    public String getId() {
        return id;
    }

    public Direction getRotationRightResult(){
        return null;
    }

    public Direction getRotationLeftResult(){
        return null;
    }

    @Override
    public String toString() {
        return id;
    }
}
