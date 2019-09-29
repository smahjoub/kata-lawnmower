package com.mowitnow.lawnowner.models;

import com.mowitnow.lawnowner.events.ExecutionCompletedEvent;
import com.mowitnow.lawnowner.events.ExecutionCompletedEventListener;
import javafx.util.Pair;

import java.util.List;
import java.util.Map;

public class LawnField {
    private Area area;

    private ExecutionCompletedEventListener executionCompletedEventListener;

    public LawnField(Area area){
        this.area = area;
    }

    public void execute(Map<LawnOwner, List<Command>> process){

        for (Map.Entry<LawnOwner, List<Command>> me: process.entrySet()) {
            final LawnOwner currentLawnOwner = me.getKey();
            for(Command command: me.getValue()){
                final Pair<Coordinate, Direction> commandResult = executeCommand(currentLawnOwner,command);
                final Coordinate nextCoordinate = commandResult.getKey();
                // check if the next coordinate is inside the given area
                if(!area.isOutOfArea(nextCoordinate)){
                    // Update position and direction
                    currentLawnOwner.setCurrentPosition(commandResult.getKey());
                    currentLawnOwner.setCurrentDirection(commandResult.getValue());
                }
            }

            if(executionCompletedEventListener != null){
                executionCompletedEventListener
                        .onExecutionCompletedEvent(new ExecutionCompletedEvent(
                                currentLawnOwner,
                                currentLawnOwner.getCurrentPosition(),
                                currentLawnOwner.getCurrentDirection()));
            }
        }

    }


    private Pair<Coordinate, Direction> executeCommand(LawnOwner l, Command c) {
        Coordinate coordinate = new Coordinate(l.getCurrentPosition().getX(),
                l.getCurrentPosition().getY());
        Direction direction = l.getCurrentDirection();
        switch (c){
            case A:
                coordinate.move(l.getCurrentDirection());
                break;
            case D:
                direction = direction.getRotationRightResult();
                break;
            case G:
                direction = direction.getRotationLeftResult();
                break;

        }

        return new Pair<>(coordinate, direction);
    }


    public void setExecutionCompletedEventListener(ExecutionCompletedEventListener executionCompletedEventListener) {
        this.executionCompletedEventListener = executionCompletedEventListener;
    }
}
