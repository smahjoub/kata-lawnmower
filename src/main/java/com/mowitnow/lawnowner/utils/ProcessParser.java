package com.mowitnow.lawnowner.utils;

import com.mowitnow.lawnowner.exceptions.InvalidInputFormat;
import com.mowitnow.lawnowner.models.*;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.*;
import java.util.regex.Pattern;
import java.util.stream.Collectors;


public class ProcessParser {

    final static String AREA_PATTERN = "\\d+ \\d+";
    final static String LAWNOWNER_PATTERN = "\\d+ \\d+ [NSEW]";
    final static String COMMANDS_PATTERN = "[GDA]+";

    enum ParsingStep {
        Area,
        LawnOwner,
        Commands
    }

    public static ParsingResult parse(InputStream input) throws InvalidInputFormat {
        List<String> lines = new BufferedReader(new InputStreamReader(input))
                .lines().collect(Collectors.toList());

        ParsingStep currentStep = ParsingStep.Area;

        Area area = null;
        LawnOwner lawnOwner = null;
        Map<LawnOwner, List<Command>> process = new LinkedHashMap<>();

        for (String line:
             lines) {
            switch (currentStep){
                case Area:
                    area = parseArea(line);
                    currentStep = ParsingStep.LawnOwner;
                    break;
                case LawnOwner:
                    lawnOwner = parseLawnOwner(line);
                    currentStep = ParsingStep.Commands;
                    break;
                case Commands:
                    process.put(lawnOwner, parseCommands(line));
                    currentStep = ParsingStep.LawnOwner;
                    lawnOwner = null;
                    break;
            }
        }


        return new ParsingResult(area, process);
    }

    private static Area parseArea(String line) throws InvalidInputFormat {
        if(Pattern.matches(AREA_PATTERN, line)){
            String[] args = line.split(" ");
            return new Area(Integer.parseInt(args[0]), Integer.parseInt(args[1]));
        } else {
            throw new InvalidInputFormat("Area pattern expected");
        }
    }

    private static LawnOwner parseLawnOwner(String line) throws InvalidInputFormat {
        if(Pattern.matches(LAWNOWNER_PATTERN, line)){
            String[] args = line.split(" ");
            return new LawnOwner(new Coordinate(Integer.parseInt(args[0]), Integer.parseInt(args[1])),
                    Direction.valueOf(args[2]));
        } else {
            throw new InvalidInputFormat("LawnOwner pattern expected");
        }
    }

    private static List<Command> parseCommands(String line) throws InvalidInputFormat {
        if(Pattern.matches(COMMANDS_PATTERN, line)){
            final List<Command> commands = new ArrayList<>();
            for(int i = 0; i < line.length(); i++){
                commands.add(Command.valueOf(String.valueOf(line.charAt(i))));
            }
            return Collections.unmodifiableList(commands);
        } else {
            throw new InvalidInputFormat("Commands pattern expected");
        }
    }
}
