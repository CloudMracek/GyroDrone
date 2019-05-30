package me.seager.tellocontroll;

public enum Direction {

    FORWARD("f"),
    LEFT("l"),
    RIGHT("r"),
    BACK("b");

    private String dir;

    Direction(String directon) {this.dir = directon;}
    public String getDirection() {return dir;}


}
