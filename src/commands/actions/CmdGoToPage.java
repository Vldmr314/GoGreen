package commands.actions;

import client.Client;
import commands.Command;
import commands.CommandFactory;
import pages.Page;
import server.Role;

import java.io.Serializable;
import java.util.List;
import java.util.Scanner;

public class CmdGoToPage extends Command implements Serializable {

    public CmdGoToPage(Role accessRole) {
        this.accessRole = accessRole;
    }

    @Override
    public void execute() {
        if (CommandFactory.client.getCurrentPage().nextPages.size() == 0) {
            System.out.println("Nothing to go\n");
            return;
        }

        CommandFactory.getCommandByStr("print_attached_links").execute();

        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter index of page to go: ");

        int index = scanner.nextInt();

        List<Page> pages = CommandFactory.client.getCurrentPage().nextPages;

        if (index < 1 || index > pages.size()) {
            System.out.println("Incorrect index\n");
            return;
        }

        CommandFactory.client.setCurrentPage(pages.get(index - 1));

        System.out.println();
    }

    /**
     * Returns the description of a command.
     *
     * @return the description of a command
     */
    @Override
    public String getDescription() {
        return "Moves client to another page";
    }
}
