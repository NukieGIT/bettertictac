package nuk.logic;

import java.awt.*;

public class Figure {
    private String figure;
    private Color clr;

    public String getFigure() {
        return figure;
    }

    public void setFigure(String figure) {
        this.figure = figure;
    }

    public Color getClr() {
        return clr;
    }

    public void setClr(Color clr) {
        this.clr = clr;
    }

    public Figure(String figure, Color clr) {
        this.figure = figure;
        this.clr = clr;
    }

}
