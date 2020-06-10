/**
 * Subclass of the Shape class for a rectangle object.
 */
public class Rectangle extends Shape {
    private int height;
    private int width;

    /**
     * Main constructor.
     * @param id Integer ID of the object.
     * @param h Integer height of the rectangle.
     * @param w Integer width of the rectangle.
     */
    Rectangle(int id, int h, int w) {
        super(id);
        this.id = id;
        height = h;
        width = w;
        area = height * width;
    }

    /**
     * Helper method to return the area of the rectangle.
     * @return Double representing the area of the rectangle.
     */
	@Override
    public double getArea() {
        return area;
    }

    /**
     * Helper method to return the height of the rectangle.
     * @return Integer representing the height of the rectangle.
     */
    public int height() {
        return height;
    }

    /**
     * Helper method to return the width of the rectangle.
     * @return Integer representing the width of the rectangle.
     */
    public int width() {
        return width;
    }

    /**
     * Helper method to return the String representation of the object (used for printing).
     * @return String representation of the rectangle object.
     */
	@Override
    public String toString() {
        return "Rectangle [width=" + width + ", height=" + height + "]";
    }
    
}