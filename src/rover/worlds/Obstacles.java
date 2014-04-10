package rover.worlds;

import java.util.Arrays;
import java.util.List;

import rover.Position;

public class Obstacles {

    private List<Position> positions;

    public Obstacles(Position... positions) {
        this.positions = Arrays.asList(positions);
    }

    public boolean obstacleAt(Position position) {
        return positions.contains(position);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Obstacles other = (Obstacles) obj;
        if (positions == null) {
            if (other.positions != null)
                return false;
        } else if (!positions.equals(other.positions))
            return false;
        return true;
    }
}
