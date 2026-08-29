package server;

import commands.Command;
import parser.ParsedCommands;

import java.util.Map;

public class CommandHandler {
    public static void handle(ParsedCommands command, Map<String, Command> commands){
        System.out.println(command.command + ": command not found");
    }
}
