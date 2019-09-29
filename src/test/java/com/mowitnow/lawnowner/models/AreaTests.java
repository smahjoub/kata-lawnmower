package com.mowitnow.lawnowner.models;

import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class AreaTests {

    @Test
    public void testIsOutOfArea(){
        Coordinate c1 = new Coordinate(-1, 2);
        Coordinate c2 = new Coordinate(2, 2);
        Coordinate c3 = new Coordinate(7, 2);
        Coordinate c4 = new Coordinate(3, 5);

        Area a1 = new Area(5,6);

        assertTrue(a1.isOutOfArea(c1));
        assertFalse(a1.isOutOfArea(c2));
        assertTrue(a1.isOutOfArea(c3));
        assertFalse(a1.isOutOfArea(c4));
    }
}
