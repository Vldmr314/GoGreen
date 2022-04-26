package commands.actions;

import client.Client;
import commands.Command;
import commands.CommandFactory;
import server.DataBase;
import server.OrderInformation;
import server.Role;

public class CmdCheckout extends Command {

    public CmdCheckout(Role accessRole) {
        this.accessRole = accessRole;
    }

    @Override
    public void execute() {
        System.out.println("THANK YOU FOR PURCHASE!\n");
        DataBase.dataBase.orders.add(new OrderInformation(DataBase.dataBase.orderNo++, CommandFactory.client.getCurrentUser().name));
        CommandFactory.client.getCurrentUser().shoppingCard.clear();
    }

    /**
     * Returns the description of a command.
     *
     * @return the description of a command
     */
    @Override
    public String getDescription() {
        return "Go to check out";
    }
}
