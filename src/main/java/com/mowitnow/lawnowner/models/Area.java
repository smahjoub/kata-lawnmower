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
        final int brx = bottomRight.getX();
        final int bry = bottomRight.getY();

        final int tlx = topLeft.getX();
        final int tly = topLeft.getY();

        final int x = c.getX();
        final int y = c.getY();

        return tlx > x || brx < x || tly > y || bry < y;
    }

    public Coordinate getTopLeft() {
        return topLeft;
    }

    public Coordinate getBottomRight() {
        return bottomRight;
    }
}
