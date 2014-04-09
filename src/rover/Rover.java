package rover;

public class Rover {

    private Location location;
    private World world;
    private SignalsToCommandsTable signalsToCommands;

    public Rover(Position position, Orientation orientation, World world) {
        this.world = world;
        this.location = new Location(position, orientation);
        this.signalsToCommands = new SignalsToCommandsTable(world);
    }

    public void receive(String signalsSequence) {
        Commands commands = signalsToCommands.translate(signalsSequence);
        location = commands.apply(location);
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
