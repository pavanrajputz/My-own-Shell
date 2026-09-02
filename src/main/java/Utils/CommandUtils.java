package Utils;


import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class CommandUtils {
    public static List<String> checkCommandInPaths(String arg){
        List<String> paths = getPaths();
        List<String> commandLocations = new ArrayList<>();
        for(String dir: paths){
            File file = new File(dir, arg);
            if(!file.exists()
            && file.canExecute()){
                commandLocations.add(file.getAbsolutePath());
            }
        }
        return commandLocations;
    }

    public static List<String> getPaths(){
        String path = System.getenv("PATH");
        System.out.println(path);
        return Arrays.stream(path.split(":")).collect(Collectors.toList());
    }
}
