package com.mowitnow.lawnowner.utils;


import com.mowitnow.lawnowner.exceptions.InvalidInputFormat;
import com.mowitnow.lawnowner.models.Command;
import com.mowitnow.lawnowner.models.Direction;
import com.mowitnow.lawnowner.models.LawnOwner;
import org.junit.Test;
import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import static org.junit.Assert.assertEquals;

public class ProcessParserTests {

    @Test
    public void testParse() throws InvalidInputFormat {
        final String inputString = "5 5" + System.lineSeparator() +
                "1 2 N" + System.lineSeparator() +
                "GAGAGAGAA" + System.lineSeparator() +
                "3 3 E" + System.lineSeparator() +
                "AADAADADDA";

        InputStream stream = new ByteArrayInputStream(inputString.getBytes(StandardCharsets.UTF_8));
        ParsingResult result = ProcessParser.parse(stream);

        assertEquals(result.getArea().getBottomRight().getX(), 5);
        assertEquals(result.getArea().getBottomRight().getY(), 5);

        Map<LawnOwner, List<Command>> process = result.getProcess();
        List<LawnOwner> lawnOwnerList = new ArrayList<>(process.keySet());

        assertEquals(lawnOwnerList.size(), 2);
        assertEquals(lawnOwnerList.get(0).getCurrentDirection(), Direction.N);
        assertEquals(lawnOwnerList.get(0).getCurrentPosition().getX(), 1);
        assertEquals(lawnOwnerList.get(0).getCurrentPosition().getY(), 2);


        assertEquals(lawnOwnerList.get(1).getCurrentDirection(), Direction.E);
        assertEquals(lawnOwnerList.get(1).getCurrentPosition().getX(), 3);
        assertEquals(lawnOwnerList.get(1).getCurrentPosition().getY(), 3);

        assertEquals(process.get(lawnOwnerList.get(0)).size(), 9);
        assertEquals(process.get(lawnOwnerList.get(1)).size(), 10);
    }
}
