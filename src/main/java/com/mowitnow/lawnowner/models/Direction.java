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
        switch (this){
            case W:
                return Direction.N;
            case E:
                return Direction.S;
            case S:
                return Direction.W;
            default:
                return Direction.E;
        }

    }

    public Direction getRotationLeftResult(){
        switch (this){
            case W:
                return Direction.S;
            case E:
                return Direction.N;
            case S:
                return Direction.E;
            default:
                return Direction.W;
        }
    }

    @Override
    public String toString() {
        return id;
    }
}
