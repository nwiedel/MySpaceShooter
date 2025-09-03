package de.nicolas;

public enum Direction {
    UP,
    DOWN,
    RIGHT,
    LEFT;

    public boolean isUP(){
        return this == UP;
    }

    public boolean isDown(){
        return this == DOWN;
    }

    public boolean isRight(){
        return this == RIGHT;
    }

    public boolean isLeft(){
        return this == LEFT;
    }
}
