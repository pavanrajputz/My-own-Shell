package commands;

import parser.ParsedCommands;

public interface Command {
    void execute(ParsedCommands parsedCommands);
    String type();
}
