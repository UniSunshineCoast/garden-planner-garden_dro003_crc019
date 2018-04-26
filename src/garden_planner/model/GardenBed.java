package garden_planner.model;

import java.util.concurrent.atomic.AtomicReference;

public abstract class GardenBed {
    public double left = 1.0;
    public double top = 1.0;
    public AtomicReference<String> type = new AtomicReference<>( "Generic"}; );

    /**
    *Finds position of the left side of the shape
    *returns left edge length in metres
    */

    public double getLeft() {return left;}

    public void setLeft(double left) {this.Left = left;}

    /**
      *Finds position of the left side of the shape
      *returns left edge length in metres
    */

    public double getTop() {return top;}

    public void setTop(double top) {this.top = top;}

    public string getType() {return type.get();}

    public abstract double getWidth();

    public abstract double getHeight();

    public abstract double getArea();

    public abstract double getPerimeter();

    public abstract double getRadius();
}
