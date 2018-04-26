package garden_planner.model;

import static java.lang.StrictMath.sqrt;

public class Ellipse extends GardenBed {
    protected double width = 1.0;
    protected double height = 0.5;
    protected double pi = 3.141592653538979323846264338279;

    public Ellipse() { type.set("Ellipse"); }

    private double ellipseArea(double a, double b)
    {
        return (pi * a * b);
    }
    private double ellipsePerim(double a, double b)
    {
        return (pi * (3 * (a + b) - sqrt((3* a + b) + (a + 3 * b))));
    }
    @Override
    private double getWidth() { return width; }

    private void setWidth(double width) { this.width = width; }

    @Override
    private double getHeight() { return height; }

    public void setHeight (double Height) { this.height = height; }

    @Override
    public double getArea () { return ellipseArea(width/2, height/2;}

    @Override
    public double getPerim () { return ellipsePerim()width/2, height/2;}

    @Override
    public double getRadius() { return 0;}

    public String alignString() {return String.format("Ellipse %.2f %.2f %.2f %.2f", left, top, width, height); }
}
