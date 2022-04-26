package commands.siteInfo;

import client.Client;
import commands.Command;
import commands.CommandFactory;
import server.Role;

import java.io.Serializable;

public class CmdPageInfo extends Command implements Serializable {

    public CmdPageInfo(Role accessRole) {
        this.accessRole = accessRole;
    }

    @Override
    public void execute() {
        System.out.println("PAGE INFO: ");

        System.out.println("Current page: " + CommandFactory.client.getCurrentPage().name);

        System.out.println();

        CommandFactory.getCommandByStr("print_attached_links").execute();

        System.out.println();
    }

    @Override
    public String getDescription() {
        return "Prints information about current page";
    }
}
