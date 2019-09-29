package com.mowitnow.lawnowner.events;

import com.mowitnow.lawnowner.models.Coordinate;
import com.mowitnow.lawnowner.models.Direction;

public class ExecutionCompletedEvent {

    private Coordinate finalCoordinate;

    private Direction finalDirection;

    public ExecutionCompletedEvent(Coordinate finalCoordinate, Direction finalDirection) {
        this.finalCoordinate = finalCoordinate;
        this.finalDirection = finalDirection;
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
