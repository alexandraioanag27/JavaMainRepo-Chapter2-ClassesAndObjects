import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class InputOutput {

    static Polynomial[] readPolynomials(String filename) {
        Polynomial[] polynomials = new Polynomial[2];

        try (BufferedReader reader = new BufferedReader(new FileReader(filename))) {
            String line;
            int count = 0;

            while ((line = reader.readLine()) != null && count < 2) {
                double[] coefficients = Arrays.stream(line.trim().split(" "))
                        .mapToDouble(Double::parseDouble)
                        .toArray();
                polynomials[count] = new Polynomial(coefficients);
                count++;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return polynomials;
    }

    public List<String> readCommands(String filename) {
        List<String> commands = new ArrayList<>();

        try (BufferedReader reader = new BufferedReader(new FileReader(filename))) {
            String line;

            reader.readLine();
            reader.readLine();

            while ((line = reader.readLine()) != null) {
                commands.add(line.trim());
            }

        } catch (IOException e) {
            e.printStackTrace();
        }

        return commands;
    }
}

