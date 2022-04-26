package commands.editting;

import client.Client;
import commands.Command;
import commands.CommandFactory;
import pages.PageFactory;
import server.Role;

import java.io.Serializable;
import java.util.*;

public class CmdAddLink extends Command implements Serializable {

    public CmdAddLink(Role accessRole) {
        this.accessRole = accessRole;
    }

    @Override
    public void execute() {
        System.out.println("ADDING NEW LINKS\n");

        CommandFactory.getCommandByStr("print_possible_pages").execute();

        System.out.print("Print using space as a delimiter indexes of links to add: ");
        Scanner scanner = new Scanner(System.in);

        String[] userInput = scanner.nextLine().split(" ");
        int[] indexes = new int[userInput.length];

        for (int i = 0; i < userInput.length; i++) {
            indexes[i] = Integer.parseInt(userInput[i].trim());

            if (indexes[i] < 1 || indexes[i] > PageFactory.getPages().size()) {
                System.out.println("Incorrect index on position " + (i+1));
                return;
            }
        }

        for (int index : indexes) {
            CommandFactory.client.getCurrentPage().insertNewPage(PageFactory.getPages().get(index - 1));
        }

        System.out.println();
    }

    @Override
    public String getDescription() {
        return "Adds links for pages to current page";
    }
}
