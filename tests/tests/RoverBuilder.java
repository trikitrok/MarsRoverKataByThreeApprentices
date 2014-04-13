package tests;

import rover.Location;
import rover.Rover;
import rover.SignalsToCommandsTable;
import rover.World;
import rover.location.Orientation;
import rover.location.Position;
import rover.worlds.InfiniteWorld;

public class RoverBuilder {

    private World world;
    private Position position;
    private Orientation orientation;
    private SignalsToCommandsTable signalsToCommands;

    private RoverBuilder() {
        this.world = new InfiniteWorld();
        this.position = new Position(0, 0);
        this.orientation = Orientation.SOUTH;
        this.signalsToCommands = new SignalsToCommandsTable();
    }

    static public RoverBuilder aRover() {
        return new RoverBuilder();
    }

    public Rover build() {
        return new Rover(new Location(this.position, this.orientation, this.world),
                this.signalsToCommands);
    }

    public RoverBuilder facing(Orientation orientation) {
        this.orientation = orientation;
        return this;
    }

    public RoverBuilder at(int x, int y) {
        this.position = new Position(x, y);
        return this;
    }

    public RoverBuilder at(Position position) {
        this.position = position;
        return this;
    }

    public RoverBuilder in(World world) {
        this.world = world;
        return this;
    }
}
