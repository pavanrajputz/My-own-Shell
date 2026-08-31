package commands;

import parser.ParsedCommands;

import java.util.List;

public class ExitCommand implements Command{
    @Override
    public void execute(ParsedCommands command) {
        StatusReport report = checkArgs(command.args);
        if(report.success){
            System.exit(report.exitCode);
        }
    }

    private StatusReport checkArgs(List<String> args) {
        StatusReport report = new StatusReport();
        report.success = false;
        report.exitCode = 1;
        if(args.isEmpty()) {
            report.success = true;
            report.exitCode = 0;
            return report;
        }else if(args.size() > 1){
            System.out.println("exit: too many arguments");
            return report;
        }else{
            report.success = true;
            String arg = args.getFirst();
            try{
                report.exitCode = Integer.parseInt(arg);
            }catch(NumberFormatException e){
                System.out.println("exit: "+args+" : numeric argument required");
                report.success = false;
            }
        }
        return report;
    }

    static class StatusReport{
        public boolean success;
        public int exitCode;
    }
}
