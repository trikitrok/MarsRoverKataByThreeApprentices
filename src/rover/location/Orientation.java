package rover.location;

import javax.management.RuntimeErrorException;

public enum Orientation {

    SOUTH {
        public Position move(int displacement, Position old) {
            return old.displaceInY(-displacement);
        }

        public Orientation rotateLeft() {
            return Orientation.EAST;
        }

        public Orientation rotateRight() {
            return Orientation.WEST;
        }

        public String toString() {
            return "South";
        }
    },

    NORTH {
        public Position move(int displacement, Position old) {
            return old.displaceInY(displacement);
        }

        public Orientation rotateLeft() {
            return Orientation.WEST;
        }

        public Orientation rotateRight() {
            return Orientation.EAST;
        }

        public String toString() {
            return "North";
        }
    },

    EAST {
        public Position move(int displacement, Position old) {
            return old.displaceInX(displacement);
        }

        public Orientation rotateLeft() {
            return Orientation.NORTH;
        }

        public Orientation rotateRight() {
            return Orientation.SOUTH;
        }

        public String toString() {
            return "East";
        }
    },

    WEST {
        public Position move(int displacement, Position old) {
            return old.displaceInX(-displacement);
        }

        public Orientation rotateLeft() {
            return Orientation.SOUTH;
        }

        public Orientation rotateRight() {
            return Orientation.NORTH;
        }

        public String toString() {
            return "West";
        }
    };

    public Position move(int displacement, Position old) {
        throw new RuntimeErrorException(null, "move");
    }

    public Orientation rotateLeft() {
        throw new RuntimeErrorException(null, "rotateLeft");
    }

    public Orientation rotateRight() {
        throw new RuntimeErrorException(null, "rotateRight");
    }

    public String toString() {
        throw new RuntimeErrorException(null, "rotateRight");
    }
}
