/**
 * Subclass of the Shape class for a circle object.
 */
public class Circle extends Shape {
    private double radius;

    /**
     * Main constructor
     * @param id Integer ID of the object.
     * @param r Double value representing the circle radius.
     */
    Circle(int id, double r) {
        super(id);
        this.id = id;
        radius = r;
        area = Math.PI * Math.pow(radius, 2);
    }

    /**
     * Helper method to return the area of the circle.
     * @return Double representing the area of the circle.
     */
	@Override
    public double getArea() {
        return area;
    }

    /**
     * Helper method to return the radius of the circle.
     * @return Double representing the radius of the circle.
     */
    public double radius() {
        return radius;
    }

    /**
     * Helper method to return the String representation of the object (used for printing).
     * @return String representation of the circle object.
     */
	@Override
    public String toString() {
        return "Circle [radius=" + radius + "]";
    }
}