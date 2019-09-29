package com.mowitnow.lawnowner.models;



public final class Coordinate {

    private int x;

    private int y;

    public Coordinate(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }


    public void move(Direction d){
    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        if(obj instanceof Coordinate){
            Coordinate c = (Coordinate)obj;
            return getX() == c.getX() && getY() == c.getY();
        }
        return false;
    }

    @Override
    public String toString() {
        return x + " " + y;
    }
}
