package commands;

import server.Role;

import java.io.Serializable;

public abstract class Command implements Serializable {
    public Role accessRole  = null;

    public abstract void execute();
    public abstract String getDescription();
}
