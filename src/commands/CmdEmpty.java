package commands;

import java.io.Serializable;

public class CmdEmpty extends Command implements Serializable {

    @Override
    public void execute() {
        System.out.println("Such commands.Command does not exist");
    }

    @Override
    public String getDescription() {
        return "Uses when user enter not correct command name";
    }
}
