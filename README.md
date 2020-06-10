# Java List Exercise

This app demonstrates some operations on a Java List.

It performs the following operations:

- Read data from a CSV file,
- Build a list of Shape objects,
- Print the contents of the list of Shape objects,
- Sort the list by area in ascending order,
- Print the contents of the sorted list.

The program was tested with a variety of input files to test for failure cases such as:
- Empty file,
- Just header (no shape data),
- File with corrupted data (integers with string characters),
- File with missing data (missing shape ID, missing shape type, and missing radius/length/width).

## How to compile app from source
```
javac Runner.java
```

## How to package the app into an executable
```
jar cfe runner.jar Runner *.class
```

## How to run app
```
java -jar runner.jar data.csv
```
