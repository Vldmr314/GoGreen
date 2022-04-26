package commands.siteInterface;

import commands.Command;
import server.DataBase;
import server.Role;

import java.io.Serializable;

public class CmdQuit extends Command implements Serializable {

    public CmdQuit(Role accessRole) {
        this.accessRole = accessRole;
    }

    /**
     * Executes the command.
     */
    @Override
    public void execute() {
        DataBase.save();

        System.exit(0);
    }

    /**
     * Returns the description of the command.
     *
     * @return the description of the command
     */
    @Override
    public String getDescription() {
        return "Exit the program";
    }
}
