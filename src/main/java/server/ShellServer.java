package server;

import commands.Command;
import parser.ParsedCommands;

import java.util.Map;
import java.util.Scanner;

public class ShellServer {
    public static void start(Map<String, Command> commands) {
        while(true){
            System.out.println("$ ");
            Scanner sc = new Scanner(System.in);
            String line = sc.nextLine();
            ParsedCommands command = ParsedCommands.fromInput(line);
            CommandHandler.handle(command, commands);
        }
    }
}
