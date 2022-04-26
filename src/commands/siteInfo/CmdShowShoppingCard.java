package commands.siteInfo;

import client.Client;
import commands.Command;
import commands.CommandFactory;
import server.Role;
import server.product.ProductSpecificationFactory;

public class CmdShowShoppingCard extends Command {

    public CmdShowShoppingCard(Role accessRole) {
        this.accessRole = accessRole;
    }

    @Override
    public void execute() {
        System.out.println("SHOPPING LIST:\n");

        int totalPrice = 0;

        for (ProductSpecificationFactory product : CommandFactory.client.getCurrentUser().shoppingCard) {
            System.out.println(product.parameters.get(0).description + " " + product.price + "$");
            totalPrice += product.price;
        }

        System.out.println();

        System.out.println("Total price: " + totalPrice);
    }

    @Override
    public String getDescription() {
        return "Print my shopping list";
    }
}
