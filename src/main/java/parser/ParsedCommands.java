package parser;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ParsedCommands {
    public String command;
    public List<String> args;

    public static ParsedCommands fromInput(String line ){
        ParsedCommands res = new ParsedCommands();
        String[] parts = line.split(" ");
        res.command = parts[0];
        res.args = Arrays.asList(parts).subList(1, parts.length);
        return res;
    }
}
