import java.util.Scanner;

/**
 * Author: Michal Szynkiewicz, michal.l.szynkiewicz@gmail.com
 * Date: 3/1/16
 * Time: 10:41 PM
 */
public class App {
    public static final String USAGE = "USAGE\n" +
            "\n" +
            "Type name of the shape, provide the required dimensions and the program will print out the area of the shape.\n" +
            "\n" +
            "Enter \"quit\" to exit\n";

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String command;
        while () { // todo dopóki wczytane polecenie jest różne od "quit"
            String name = trim(command);
            Shape shape = ShapeFactory.getShape(name);
            if (shape == null) {
                System.out.println(USAGE);
                System.out.println("Supported shapes: " + ShapeFactory.getSupportedShapes());
            } else {
                shape.readDimensions(scanner);
                System.out.println("Area of " + shape.getName() + " is : " + shape.getArea());
            }
        }
    }

    private static String trim(String command) {
        return command.trim().toLowerCase();
    }
}
