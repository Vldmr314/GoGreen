package commands.editting;

import commands.Command;
import pages.Page;
import pages.PageFactory;
import server.Role;

import java.io.Serializable;
import java.util.Scanner;

public class CmdRemoveProduct extends Command implements Serializable {

    public CmdRemoveProduct(Role accessRole) {
        this.accessRole = accessRole;
    }

    @Override
    public void execute() {
        System.out.println("REMOVING PAGE");

        int pageNumber = 1;
        for (Page page : PageFactory.getPages()) {
            System.out.println((pageNumber++) + ". " + page.name);
        }

        System.out.print("Enter index of page ro delete: ");
        Scanner scanner = new Scanner(System.in);

        try {
            int index = scanner.nextInt();
            PageFactory.getPages().remove(index - 1);
        } catch (Exception ex) {
            System.out.println("Invalid index");
        }
    }

    @Override
    public String getDescription() {
        return "Remove page";
    }
}
