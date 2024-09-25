package models;

public class Player {
    private String name;
    private String figure;
    private int points;

    public Player() {
    }

    public Player(int points, String figure, String name) {
        this.points = points;
        this.figure = figure;
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getFigure() {
        return figure;
    }

    public void setFigure(String figure) {
        this.figure = figure;
    }

    public int getPoints() {
        return points;
    }

    public void setPoints(int points) {
        this.points = points;
    }
}
