package rover;

import java.util.Arrays;
import java.util.List;

import rover.commands.MoveBackwards;
import rover.commands.MoveForwards;
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

    private void receiveOneCommand(String command) {
        if (command.equals("")) {
            return;
        }

        if ("l".equals(command)) {
            this.location = rotateLeft(command, this.location, this.world);
        } else if ("r".equals(command)) {
            Command rotateRight = new RotateRight();
            this.location = rotateRight.apply(location);
        } else if (command.equals("f")) {
            Command moveForwards = new MoveForwards(world);
            this.location = moveForwards.apply(location);
        } else {
            Command movebackwards = new MoveBackwards(world);
            this.location = movebackwards.apply(location);
        }
    }

    private Location rotateRight(String command, Location location, World world) {
        return new Location(location.getPosition(), location.getOrientation().rotateRight());
    }

    private Location rotateLeft(String command, Location location, World world) {
        return new Location(location.getPosition(), location.getOrientation().rotateLeft());
    }

    private Location move(String command, Location location, World world) {
        Position tentativePosition = location.getOrientation().move(computeDisplacement(command),
                location.getPosition());

        if (world.hasObstacleAt(tentativePosition)) {
            throw new ObstacleFoundException();
        }
        return new Location(world.wrap(tentativePosition), location.getOrientation());
    }

    private int computeDisplacement(String command) {
        if (command.equals("f")) {
            return 1;
        }
        return -1;
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
