package commands.actions;

import client.Client;
import commands.Command;
import commands.CommandFactory;
import pages.PageProduct;
import server.Role;

public class CmdPutInShoppingCard extends Command {

    public CmdPutInShoppingCard(Role accessRole) {
        this.accessRole = accessRole;
    }

    @Override
    public void execute() {
        CommandFactory.client.getCurrentUser().shoppingCard.add(((PageProduct)CommandFactory.client.getCurrentPage()).specifications);

        System.out.println("##################\n"+
                           "###### DONE ######\n"+
                           "##################");
    }

    /**
     * Returns the description of a command.
     *
     * @return the description of a command
     */
    @Override
    public String getDescription() {
        return "Add item to card";
    }
}
