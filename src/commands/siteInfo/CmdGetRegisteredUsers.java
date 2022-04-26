package commands.siteInfo;

import commands.Command;
import server.DataBase;
import server.Role;
import server.User;

import java.io.Serializable;
import java.util.List;

public class CmdGetRegisteredUsers extends Command implements Serializable {

    public CmdGetRegisteredUsers(Role accessRole) {
        this.accessRole = accessRole;
    }

    @Override
    public void execute() {
        System.out.println("REGISTERED USERS LIST:");

        List<User> users = DataBase.getUsers();

        int userNumber = 1;
        for (User user : users) {
            System.out.println((userNumber++) + ". name: " + user.name + " login: " + user.login
                                              + " role: " + user.role + " password: " + user.password);

            System.out.println();
        }

        System.out.println();
    }

    @Override
    public String getDescription() {
        return "Print the list of all registered users";
    }
}
