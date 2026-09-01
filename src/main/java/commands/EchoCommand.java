package commands;

import parser.ParsedCommands;

public class EchoCommand implements Command{
    @Override
    public void execute(ParsedCommands command) {
        if(command.args.isEmpty()){
            System.out.println();
        }else {
            System.out.println(String.join(" ", command.args));
        }
    }

    @Override
    public String type() {
        return "echo is shell builtin";
    }
}
