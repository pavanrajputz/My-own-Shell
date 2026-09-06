package commands;

import parser.ParsedCommands;

public class PwdCommand implements Command {
    @Override
    public void execute(ParsedCommands parsedCommands) {
        System.out.println(System.getProperty("user.dir"));
    }

    @Override
    public String type() {
        return "pwd is a shell builtin";
    }
}
