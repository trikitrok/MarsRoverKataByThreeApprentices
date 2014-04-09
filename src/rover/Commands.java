package rover;

import java.util.List;

public class Commands {

    private List<Command> commands;

    public Commands(List<Command> commands) {
        this.commands = commands;
    }

    public Location apply(Location location) {
        for (Command command : commands) {
            location = command.apply(location);
        }
        return location;
    }

}
