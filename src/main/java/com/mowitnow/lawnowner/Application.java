package com.mowitnow.lawnowner;

import com.mowitnow.lawnowner.exceptions.InvalidInputFormat;
import com.mowitnow.lawnowner.models.LawnField;
import com.mowitnow.lawnowner.utils.ParsingResult;
import com.mowitnow.lawnowner.utils.ProcessParser;

import java.io.*;

public class Application {

    public static void main(String[] args){

        if(args.length != 2){
            System.err.println("Wrong program input !");
            System.exit(-1);
        }
        System.out.println("lawn owner app!");

        final String inputFile =  args[0];
        final String outputFile = args[1];
        ParsingResult pr = null;

        try {
            pr = ProcessParser.parse(new FileInputStream(inputFile));
        } catch (InvalidInputFormat invalidInputFormat) {
            System.err.println(invalidInputFormat.getMessage());
            System.exit(-1);
        } catch (FileNotFoundException e) {
            System.err.println("Unable to locate the input file: " + args[0]);
            System.exit(-1);
        }

        LawnField field = new LawnField(pr.getArea());

        field.setExecutionCompletedEventListener(e -> {
            File file = new File(outputFile);

            try {
                FileWriter fr = new FileWriter(file, true);
                fr.write(e.toString());
                fr.write(System.lineSeparator());
                fr.close();
            } catch (IOException ex) {
                System.err.println(ex.getMessage());
                System.exit(-1);
            }
        });

        field.execute(pr.getProcess());
    }
}
