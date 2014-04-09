package rover;

import java.util.Arrays;
import java.util.List;

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
            setOrientation(getOrientation().rotateLeft());
        } else if ("r".equals(command)) {
            setOrientation(getOrientation().rotateRight());
        } else {
            this.location = move(command, this.location, this.world);
        }
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

    private Position getPosition() {
        return this.location.getPosition();
    }

    private Orientation getOrientation() {
        return this.location.getOrientation();
    }

    private void setOrientation(Orientation orientation) {
        this.location = new Location(getPosition(), orientation);
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
