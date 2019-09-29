package com.mowitnow.lawnowner.utils;

import com.mowitnow.lawnowner.models.Area;
import com.mowitnow.lawnowner.models.Command;
import com.mowitnow.lawnowner.models.LawnOwner;

import java.util.List;
import java.util.Map;

public class ParsingResult {

    private Area area;

    private Map<LawnOwner, List<Command>> process;

    public ParsingResult(Area area, Map<LawnOwner, List<Command>> process) {
        this.area = area;
        this.process = process;
    }

    public Area getArea() {
        return area;
    }

    public Map<LawnOwner, List<Command>> getProcess() {
        return process;
    }
}
