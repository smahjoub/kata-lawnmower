package com.mowitnow.lawnowner.models;

public enum Command {
    G("G"),
    D("D"),
    A("A");

    private String id;

    Command(String id){
        this.id = id;
    }

    public String getId() {
        return id;
    }

    @Override
    public String toString() {
        return id;
    }
}
