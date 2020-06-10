import java.util.*;
import java.io.*;

/**
 * This program demonstrates some operations on a Java List.
 * It reads data from a CSV file, builds a list of Shape objects and performs
 * operations for searching a Shape on the list, sorting the list, and
 * printing the list contents.
 * 
 * @author Fabio Costa
 * @version 1.0
 * @since   2020-06-10
 */
public class Runner {
 
    /**
     * This is the main method which calls helper methods to:
     * 1) Load shape data from the given CSV file.
     * 2) Print information of all shapes imported (in the order they were read).
     * 3) Sort the list of shapes by area in ascending order.
     * 4) Print information of all shapes sorted by area.
     * @param args The filename containing the Shape data in CSV format.
     * @return Nothing.
     */
    public static void main(String []args) {
        String csvFilename = "";

        System.out.println("Runner start...");

        if (args.length > 0) {
            csvFilename = args[0];
        } else {
            System.out.println("No filename passed");
            System.out.println("USAGE: java -jar runner.jar <csvFilename>");
            System.exit(0);
        }

        List<Shape> listShapes = loadShapesFromFile(csvFilename);

        System.out.println("\nPrinting all shapes (unsorted)");
        printShapes(listShapes);

        System.out.println("\nPrinting all shapes (sorted by area)");
        sortByArea(listShapes);
        printShapes(listShapes);
    }

    /**
     * Helper method to find a given Shape object in the given list.
     * The criteria to match a shape object is the Shape subclass (Circle or Rectangle) and Shape ID value.
     * @param instance A given shape object to search for.
     * @param shapes The list of shapes from where the given shape will be searched.
     * @return The index in the list where the given shape was found. Return -1 if not found.
     */
    public static int findShapeIndex(Shape instance, List<Shape> shapes) {
        int indexFound = -1;
        int index = 0;
        for (Shape s : shapes) {
            if((s.getClass().equals(instance.getClass())) && (instance.getId() == s.getId())) {
                indexFound = index;
                break;
            }
            index++;
        }
        return indexFound;
    }

    /**
     * Helper method to sort a list of shapes by area in ascending order
     * @param shapes List of shape objects that will be sorted.
     */
    public static void sortByArea(List<Shape> shapes) {
        Collections.sort(shapes);
    }

    /**
     * Helper method to print information about every shape in the given list.
     * The format to be printed is provided by the object's toString() method.
     * @param shapes List of shape objects that will be printed to console.
     */
    public static void printShapes(List<Shape> shapes) {
        for (Shape s : shapes) {
            System.out.print(s.toString() + ", ");
        }
        System.out.println();
    }

    /**
     * Helper method that reads the shape information from the given CSV type file
     * and loads it into a list of shape objects.
     * @param filename Filename of the comma-separated values file containing shape information to load. 
     * @return List of Shape objects corresponding to the input file.
     * @exception FileNotFoundException On file read error.
     * @exception IOException On input error.
     * @exception NumberFormatException On converting values as Integer and Double error.
     */
    public static List<Shape> loadShapesFromFile(String filename) {
        List<Shape> list = new ArrayList<>();
        int id = 0;
        String shapeType = "";
        double radius = 0.0;
        int width = 0;
        int height = 0;
        Shape shape = null;

        System.out.println("\nReading shapes...");
        try (BufferedReader br = new BufferedReader(new FileReader(filename))) {
            String line;
            // the first line of the file contains the header so let's skip it
            br.readLine();
            while ((line = br.readLine()) != null) {
                shape = null;
                String[] values = line.split(",");
                // basic integrity check (skip line if it has less than the minimum 3 fields)
                if(values.length >= 3) {
                    id = Integer.parseInt(values[0]);
                    shapeType = values[1];
                    // check the shape type in order to create the proper Shape objects
                    if("circle".equalsIgnoreCase(shapeType)) {
                        radius = Double.parseDouble(values[2]);
                        System.out.println("Read circle with id " + id);
                        shape = new Circle(id, radius);
                    } else if(("rectangle".equalsIgnoreCase(shapeType)) && (values.length >= 4)) {
                        width = Integer.parseInt(values[2]);
                        height = Integer.parseInt(values[3]);
                        System.out.println("Read rectangle with id " + id);
                        shape = new Rectangle(id, height, width);
                    }
                    // if no errors were found thus far, add object to the list
                    if(shape != null) {
                        list.add(shape);
                    }
                }
            }
        } catch (FileNotFoundException e)
        {
            // COULD NOT FIND FILE
            e.printStackTrace();
        } catch (IOException e)
        {
            // COULD NOT READ FILE
            e.printStackTrace();
        } catch (NumberFormatException e)
        {
            // COULD NOT CONVERT ONE OF THE INTEGERS
            e.printStackTrace();
        }
        
        System.out.println("*** Returning list with " + list.size() + " elements");
        return list;
    }
 }