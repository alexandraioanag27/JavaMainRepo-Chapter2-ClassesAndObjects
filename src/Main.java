import java.util.List;

public class Main {
    public static void main(String[] args) {
        String filename = "C:\\Users\\alexi\\Downloads\\JavaMainRepo - Chapter 2 - Classes and Objects\\src\\Pol.txt";
        InputOutput io = new InputOutput();

        Polynomial[] polynomials = io.readPolynomials(filename);
        Polynomial poly1 = polynomials[0];
        Polynomial poly2 = polynomials[1];

        List<String> commands = io.readCommands(filename);

        Function functions = new Function(poly1, poly2);

        for (String command : commands) {
            String result = functions.execute(command);
            System.out.println(result);
        }
    }
}
