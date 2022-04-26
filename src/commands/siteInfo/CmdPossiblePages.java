package commands.siteInfo;

import commands.Command;
import pages.Page;
import pages.PageFactory;
import server.Role;

import java.io.Serializable;
import java.util.List;

public class CmdPossiblePages extends Command implements Serializable {

    public CmdPossiblePages(Role accessRole) {
        this.accessRole = accessRole;
    }

    @Override
    public void execute() {
        System.out.println("AVAILABLE PAGES:");

        List<Page> pages = PageFactory.getPages();

        int pageNumber = 1;
        for (Page page : pages)
            System.out.println((pageNumber++) + ". " + page.name);

        System.out.println();
    }

    @Override
    public String getDescription() {
        return "Prints all pages that can be used in site";
    }
}
