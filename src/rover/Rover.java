package rover;

import java.util.Arrays;
import java.util.List;

import rover.commands.MoveBackwards;
import rover.commands.MoveForwards;
import rover.commands.RotateLeft;
import rover.commands.RotateRight;

public class Rover {

    private Location location;
    private World world;

    public Rover(Position position, Orientation orientation, World world) {
        this.world = world;
        this.location = new Location(position, orientation);
    }

    public void receive(String commandsSequence) {
        List<String> commands = extractCommands(commandsSequence);

        for (String command : commands) {
            receiveOneCommand(command);
        }
    }

    private List<String> extractCommands(String commandsSequence) {
        return Arrays.asList(commandsSequence.split(""));
    }

    private void receiveOneCommand(String signal) {
        if (signal.equals("")) {
            return;
        }

        Command command;

        if ("l".equals(signal)) {
            command = new RotateLeft();
            this.location = command.apply(location);
        } else if ("r".equals(signal)) {
            command = new RotateRight();
            this.location = command.apply(location);
        } else if (signal.equals("f")) {
            command = new MoveForwards(world);
            this.location = command.apply(location);
        } else {
            command = new MoveBackwards(world);
            this.location = command.apply(location);
        }
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((location == null) ? 0 : location.hashCode());
        result = prime * result + ((world == null) ? 0 : world.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Rover other = (Rover) obj;
        if (location == null) {
            if (other.location != null)
                return false;
        } else if (!location.equals(other.location))
            return false;
        if (world == null) {
            if (other.world != null)
                return false;
        } else if (!world.equals(other.world))
            return false;
        return true;
    }
}
