package com.mowitnow.lawnowner.events;

import com.mowitnow.lawnowner.models.Coordinate;
import com.mowitnow.lawnowner.models.Direction;
import com.mowitnow.lawnowner.models.LawnOwner;

public class ExecutionCompletedEvent {

    private LawnOwner lawnOwner;

    private Coordinate finalCoordinate;

    private Direction finalDirection;

    public ExecutionCompletedEvent(LawnOwner lawnOwner,
                                   Coordinate finalCoordinate, Direction finalDirection) {
        this.lawnOwner = lawnOwner;
        this.finalCoordinate = finalCoordinate;
        this.finalDirection = finalDirection;
    }

    public LawnOwner getLawnOwner() {
        return lawnOwner;
    }

    public Coordinate getFinalCoordinate() {
        return finalCoordinate;
    }

    public Direction getFinalDirection() {
        return finalDirection;
    }

    @Override
    public String toString() {
        return finalCoordinate + " " + finalDirection;
    }
}
