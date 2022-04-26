package commands.siteInfo;

import client.Client;
import commands.Command;
import commands.CommandFactory;
import pages.Page;
import server.Role;

import java.io.Serializable;
import java.util.List;

public class CmdPrintAttachedLinks extends Command implements Serializable {

    public CmdPrintAttachedLinks(Role accessRole) {
        this.accessRole = accessRole;
    }

    @Override
    public void execute() {
        System.out.println("ATTACHED LINKS:");

        List<Page> pages = CommandFactory.client.getCurrentPage().nextPages;

        for (int i = 0; i < pages.size(); i++) {
            System.out.println((i+1) + ". " + pages.get(i).name);
        }

        System.out.println();
    }

    @Override
    public String getDescription() {
        return "Prints all links attached to the current page";
    }
}
