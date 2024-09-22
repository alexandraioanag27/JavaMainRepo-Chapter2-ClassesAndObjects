import java.util.List;

public class Main {
    public static void main(String[] args) {
        String filename = "C:\\Users\\alexi\\Downloads\\JavaMainRepo - Chapter 2 - Classes and Objects\\src\\Pol.txt";
        InputOutput io = new InputOutput();

        // Read the polynomials from the file
        Polynomial[] polynomials = io.readPolynomials(filename);
        Polynomial poly1 = polynomials[0];
        Polynomial poly2 = polynomials[1];

        // Read the commands from the file
        List<String> commands = io.readCommands(filename);

        // Create a Functions object
        Function functions = new Function(poly1, poly2);

        // Execute each command and print the result
        for (String command : commands) {
            String result = functions.execute(command);
            System.out.println(result);
        }
    }
}
