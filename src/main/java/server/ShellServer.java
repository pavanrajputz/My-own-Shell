package server;

import commands.Command;
import parser.ParsedCommands;

import java.util.Map;
import java.util.Scanner;

public class ShellServer {
    public static void start(Map<String, Command> commands) {

        Scanner sc = new Scanner(System.in);
        while(true){
            System.out.print("$ ");
            String line = sc.nextLine();
            ParsedCommands command = ParsedCommands.fromInput(line);
            CommandHandler.handle(command, commands);
        }
    }
}
