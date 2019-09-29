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
        switch (d){
            case N:
                y = y + 1;
                break;
            case S:
                y = y - 1;
                break;
            case E:
                x = x + 1;
                break;
            case W:
                x = x - 1;
                break;
        }
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
