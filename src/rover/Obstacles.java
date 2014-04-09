package rover;

import java.util.Arrays;
import java.util.List;

public class Obstacles {

    private List<Position> positions;

    public Obstacles(Position... positions) {
        this.positions = Arrays.asList(positions);
    }

    public boolean obstacleAt(Position position) {
        return positions.contains(position);
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((positions == null) ? 0 : positions.hashCode());
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
        Obstacles other = (Obstacles) obj;
        if (positions == null) {
            if (other.positions != null)
                return false;
        } else if (!positions.equals(other.positions))
            return false;
        return true;
    }
}
