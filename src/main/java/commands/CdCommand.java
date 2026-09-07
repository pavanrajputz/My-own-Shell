package commands;

import Utils.CommandUtils;
import parser.ParsedCommands;

import java.io.File;
import java.net.URLDecoder;

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
            System.setProperty("user.dir", getHomeDir());
            return;
        }

        String targetPath = commands.args.getFirst();

        try{
            File targetDir = CommandUtils.resolvePath(targetPath);
            if(!targetDir.exists()){
                System.out.println("cd: "+commands.args.getFirst()+": No such file or directory");
                return;
            }
            if(!targetDir.isDirectory()){
                System.out.println("cd: "+commands.args.getFirst()+": Not a directory");
                return;
            }
            System.setProperty("user.dir", targetDir.getAbsolutePath());
        }catch (Exception e){
            System.out.println("cd: "+commands.args.getFirst()+": "+e.getMessage());
        }

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
