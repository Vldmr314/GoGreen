package commands.siteInterface;

import client.Client;
import commands.Command;
import commands.CommandFactory;
import server.DataBase;
import server.Role;
import server.User;

import java.io.Serializable;
import java.util.Scanner;

public class CmdAuthorize extends Command implements Serializable {

    public CmdAuthorize(Role accessRole) {
        this.accessRole = accessRole;
    }

    @Override
    public void execute() {
        System.out.println("AUTHORIZATION:");

        Scanner scanner = new Scanner(System.in);

        String login;
        String password;

        System.out.print("Enter your login: ");
        login = scanner.next();

        System.out.print("Enter your password: ");
        password = scanner.next();

        User user;

        if ((user = DataBase.getUserByData(login, password)) == null)
            System.out.println("Server.User with such data was not found");
        else {
            System.out.println("Welcome back, " + user.name + "!");
            CommandFactory.client.setCurrentUser(user);
        }

        System.out.println();
    }

    @Override
    public String getDescription() {
        return "Authorize the user";
    }
}
