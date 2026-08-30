package server;

import commands.Command;
import parser.ParsedCommands;

import java.util.Map;

public class CommandHandler {
    public static void handle(ParsedCommands command, Map<String, Command> commands){
        if(commands.containsKey(command.command)){
            commands.get(command.command).execute(command);
        }else{
            System.out.println(command.command + ": command not found");
        }
    }
}
