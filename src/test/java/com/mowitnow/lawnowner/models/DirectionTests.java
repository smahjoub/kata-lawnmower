package com.mowitnow.lawnowner.models;

import org.junit.Test;

import static org.junit.Assert.assertTrue;

public class DirectionTests {

    @Test
    public void testRotationLeft(){

        assertTrue(Direction.N.getRotationLeftResult() == Direction.W);
        assertTrue(Direction.W.getRotationLeftResult() == Direction.S);
        assertTrue(Direction.S.getRotationLeftResult() == Direction.E);
        assertTrue(Direction.E.getRotationLeftResult() == Direction.N);
    }

    @Test
    public void testRotationRight(){
        assertTrue(Direction.N.getRotationRightResult() == Direction.E);
        assertTrue(Direction.E.getRotationRightResult() == Direction.S);
        assertTrue(Direction.S.getRotationRightResult() == Direction.W);
        assertTrue(Direction.W.getRotationRightResult() == Direction.N);
    }
}
