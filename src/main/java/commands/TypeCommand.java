package commands;

import Utils.CommandUtils;
import parser.ParsedCommands;

import java.util.List;
import java.util.Map;

public class TypeCommand implements Command {

    Map<String, Command> commands;

    public TypeCommand(Map<String, Command> commands) {
        this.commands = commands;
    }

    @Override
    public void execute(ParsedCommands command) {
        for(String arg: command.args){
            if(commands.containsKey(arg)){
                String type = commands.get(arg).type();
                System.out.println(type);
            }else{
                if(!checkInPath(arg)){
                    System.out.println(arg+": not found");
                }
            }
        }
    }

    @Override
    public String type() {
        return "type is shell builtin";
    }

    private boolean checkInPath(String arg){
        List<String> paths = CommandUtils.checkCommandInPaths(arg);
        if(!paths.isEmpty()){

            return true;
        }
        return false;
    }
}
