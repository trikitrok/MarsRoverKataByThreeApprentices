package rover;

import javax.management.RuntimeErrorException;

public enum Orientation {

    SOUTH {
        public Position move(int displacement, Position old) {
            return new Position(old.getX(), old.getY() - displacement);
        }

        Orientation rotateLeft() {
            return Orientation.EAST;
        }

        Orientation rotateRight() {
            return Orientation.WEST;
        }
    },

    NORTH {
        public Position move(int displacement, Position old) {
            return new Position(old.getX(), old.getY() + displacement);
        }

        Orientation rotateLeft() {
            return Orientation.WEST;
        }

        Orientation rotateRight() {
            return Orientation.EAST;
        }
    },

    EAST {
        public Position move(int displacement, Position old) {
            return new Position(old.getX() + displacement, old.getY());
        }

        Orientation rotateLeft() {
            return Orientation.NORTH;
        }

        Orientation rotateRight() {
            return Orientation.SOUTH;
        }
    },

    WEST {
        public Position move(int displacement, Position old) {
            return new Position(old.getX() - displacement, old.getY());
        }

        Orientation rotateLeft() {
            return Orientation.SOUTH;
        }

        Orientation rotateRight() {
            return Orientation.NORTH;
        }
    };

    public Position move(int displacement, Position old) {
        throw new RuntimeErrorException(null, "move");
    }

    Orientation rotateLeft() {
        throw new RuntimeErrorException(null, "rotateLeft");
    }

    Orientation rotateRight() {
        throw new RuntimeErrorException(null, "rotateRight");
    }
}
