package com.mowitnow.lawnowner.models;

import org.junit.Test;

import static org.junit.Assert.assertTrue;

public class CoordinateTests {

    @Test
    public void testMove(){
        Coordinate c1 = new Coordinate(1,1);

        c1.move(Direction.S);
        assertTrue(c1.getX() == 1);
        assertTrue(c1.getY() == 0);
        c1.move(Direction.N);
        assertTrue(c1.getX() == 1);
        assertTrue(c1.getY() == 1);
        c1.move(Direction.E);
        assertTrue(c1.getX() == 2);
        assertTrue(c1.getY() == 1);
        c1.move(Direction.W);
        assertTrue(c1.getX() == 1);
        assertTrue(c1.getY() == 1);

    }

}
