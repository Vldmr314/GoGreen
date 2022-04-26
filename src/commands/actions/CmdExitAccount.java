package commands.actions;

import client.Client;
import commands.Command;
import commands.CommandFactory;
import server.Role;
import server.User;

import java.io.Serializable;

public class CmdExitAccount extends Command implements Serializable {

    public CmdExitAccount(Role accessRole) {
        this.accessRole = accessRole;
    }

    /**
     * Executes the command.
     */
    @Override
    public void execute() {
        CommandFactory.client.setCurrentUser(User.getGuest());
    }

    /**
     * Returns the description of the command.
     *
     * @return the description of the command
     */
    @Override
    public String getDescription() {
        return "Exits from account in the current client";
    }
}
