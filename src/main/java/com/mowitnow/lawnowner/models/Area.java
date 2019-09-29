package com.mowitnow.lawnowner.models;

import com.mowitnow.lawnowner.utils.Constants;

public class Area {

    private Coordinate topLeft;

    private Coordinate bottomRight;

    public Area(int height, int width){
        topLeft = new Coordinate(Constants.ZERO,
                Constants.ZERO);
        bottomRight = new Coordinate(width, height);
    }


    public boolean isOutOfArea(Coordinate c){
        return false;
    }

    public Coordinate getTopLeft() {
        return topLeft;
    }

    public Coordinate getBottomRight() {
        return bottomRight;
    }
}
