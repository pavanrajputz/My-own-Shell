package parser;

import java.util.List;

public class ParsedCommands {
    public String command;
    public List<String> args;

    public static ParsedCommands fromInput(String line ){
        ParsedCommands res = new ParsedCommands();
        String[] parts = line.split(" ");
        res.command = parts[0];
        return res;
    }
}
