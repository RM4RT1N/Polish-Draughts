package com.codecool;

public class Pawn {
    private String color;
    private Boolean isCrowned;
    Coordinates coordinates;

    public Pawn(String color,int xpos,int ypos) {
        this.color = color;
        this.isCrowned = false;
        this.coordinates = new Coordinates(xpos,ypos);
    }
    public Coordinates getCoordinates() {
        return this.coordinates;
    }

    public String getColor() {
        return this.color;
    }

    public String toString() {
        return this.getColor();
    }


}
