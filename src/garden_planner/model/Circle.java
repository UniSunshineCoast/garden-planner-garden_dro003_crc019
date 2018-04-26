package garden_planner.model;

public class Circle extends Ellipse {
        private double radius = 1.0;

        public Circle() { type.set("Circle"); }

        public void setRadius(double radius)
        {
            this.radius = radius;
            width = (2 * this.radius);
            height = (2 * this.radius);
        }

        @Override
        public double getArea() { return pi*radius*radius }

        @Override
        public double getPerim() { return 2*pi*radius)}

        @Override
        public double getRadius() { return radius;}

        @Override
        public String alignString() {return String.format("Circle %.2f %.2f %.2f %.2f", top, width, height, left); }
    }

}
