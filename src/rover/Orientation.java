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

        public Orientation rotateRight() {
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

        public Orientation rotateRight() {
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

        public Orientation rotateRight() {
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

        public Orientation rotateRight() {
            return Orientation.NORTH;
        }
    };

    public Position move(int displacement, Position old) {
        throw new RuntimeErrorException(null, "move");
    }

    Orientation rotateLeft() {
        throw new RuntimeErrorException(null, "rotateLeft");
    }

    public Orientation rotateRight() {
        throw new RuntimeErrorException(null, "rotateRight");
    }
}
