package com.mowitnow.lawnowner.models;

import com.mowitnow.lawnowner.events.ExecutionCompletedEventListener;

import java.util.List;
import java.util.Map;

public class LawnField {
    private Area area;

    private ExecutionCompletedEventListener executionCompletedEventListener;

    public LawnField(Area area){
        this.area = area;
    }

    public void execute(Map<LawnOwner, List<Command>> process){


    }

    public void setExecutionCompletedEventListener(ExecutionCompletedEventListener executionCompletedEventListener) {
        this.executionCompletedEventListener = executionCompletedEventListener;
    }
}
