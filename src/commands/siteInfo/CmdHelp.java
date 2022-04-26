package commands.siteInfo;

import commands.Command;
import commands.CommandFactory;
import server.Role;

import java.io.Serializable;
import java.util.Map;

public class CmdHelp extends Command implements Serializable {

    public CmdHelp(Role accessRole) {
        this.accessRole = accessRole;
    }

    @Override
    public void execute() {
        System.out.println("AVAILABLE COMMANDS:");

        Map<String, Command> commands = CommandFactory.getCommands();

        for (var command : commands.entrySet()) {
                System.out.println(command.getKey() + " - " + command.getValue().getDescription());
        }

        System.out.println();
    }

    @Override
    public String getDescription() {
        return "Prints all possible commands and their description";
    }
}
