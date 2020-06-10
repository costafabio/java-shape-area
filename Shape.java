/**
 * Parent class for a Shape object.
 * This class implements Comparable as to allow to use of Collections.sort() for easy sorting 
 * of a list of Shape objects.
 */
public class Shape implements Comparable<Shape> {
    int id;
    double area;

    /**
     * Main constructor.
     * @param i Integer ID of the object.
     */
    Shape(int i) {
        id = i;
    }

    /**
     * Helper method to return the area of the shape.
     * @return Double representing the area of the shape.
     */
    public double getArea() {
        return 0;
    }

    /**
     * Helper method to return the ID of the object.
     * @return Integer representing the ID of the object.
     */
    public int getId() {
        return id;
    }

    /**
     * Helper method to return the String representation of the object (used for printing).
     * @return String representation of the object.
     */
    public String toString() {
        return "Shape [id=" + id + "]";
    }

    /**
     * Override to allow Shape-derived objects to be compared against each other.
     * The comparison is solely done based on the object's area, which allows a
     * list of Shape objects to be sorted by area.
     */
	@Override
	public int compareTo(Shape s) {
		return Double.compare(this.area, s.getArea());
	}
}