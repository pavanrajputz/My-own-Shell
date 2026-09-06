package commands;

import parser.ParsedCommands;

public class CdCommand implements Command{
    @Override
    public void execute(ParsedCommands commands) {
        if(commands.args.size() > 1){
            System.out.println("cd :too many arguments");
            return;
        }else if(commands.args.isEmpty()){
            System.setProperty("user.dir", getHomeDir());
            return;
        }

        if(commands.args.getFirst().equals("~")){
            System.out.println("cd :too many arguments");
            return;
        }

        String targetPath = commands.args.getFirst();

    }

    private String getHomeDir() {
        String homeDir = System.getenv("HOME");
        if(homeDir != null
        && !homeDir.isEmpty()){
            return homeDir;
        }
        return System.getProperty("user.home");
    }

    @Override
    public String type() {
        return "cd is shell builtin";
    }
}
