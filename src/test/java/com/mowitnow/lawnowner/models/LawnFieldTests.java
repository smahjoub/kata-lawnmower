package com.mowitnow.lawnowner.models;

import com.mowitnow.lawnowner.events.ExecutionCompletedEvent;
import com.mowitnow.lawnowner.events.ExecutionCompletedEventListener;
import org.junit.Test;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.junit.Assert.*;

public class LawnFieldTests {

    @Test
    public void testExecute(){

        Map<LawnOwner, String> expectedResult = new HashMap<>();

        Area a = new Area(5,5);
        LawnOwner l1 = new LawnOwner(new Coordinate(1, 2), Direction.N);
        List<Command> commands = Arrays.asList(Command.G,Command.A,
                Command.G, Command.A,
                Command.G, Command.A,
                Command.G, Command.A, Command.A);


        LawnOwner l2 = new LawnOwner(new Coordinate(3, 3), Direction.E);
        List<Command> commands2 = Arrays.asList(Command.A,Command.A,
                Command.D, Command.A, Command.A,
                Command.D, Command.A,
                Command.D, Command.D, Command.A);

        LawnField field = new LawnField(a);

        field.setExecutionCompletedEventListener(
                (e) -> assertEquals(expectedResult.get(e.getLawnOwner()), e.toString()));

        Map<LawnOwner, List<Command>> process = new HashMap<>();
        process.put(l1, commands);
        process.put(l2, commands2);

        expectedResult.put(l1, "1 3 N");
        expectedResult.put(l2, "5 1 E");

        field.execute(process);
    }
}
