import java.util.Scanner;

/**
 * Author: Michal Szynkiewicz, michal.l.szynkiewicz@gmail.com
 * Date: 3/1/16
 * Time: 10:44 PM
 */
public interface Shape {
    void readDimensions(Scanner scanner);
    Double getArea();
    String getName();
}
