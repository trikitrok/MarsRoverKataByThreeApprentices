package rover;

public class Rover {

    private Location location;
    private SignalsToCommandsTable signalsToCommands;

    public Rover(Location location, SignalsToCommandsTable signalsToCommands) {
        this.location = location;
        this.signalsToCommands = signalsToCommands;
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
        return true;
    }
}
