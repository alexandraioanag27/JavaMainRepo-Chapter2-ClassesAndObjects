public class Function {
    private Polynomial poly1;
    private Polynomial poly2;

    public Function(Polynomial poly1, Polynomial poly2) {
        this.poly1 = poly1;
        this.poly2 = poly2;
    }

    public String execute(String command) {
        String[] parts = command.split(" ");
        String operation = parts[0];

        switch (operation) {
            case "ADD":
                return "Addition Result: " + poly1.add(poly2).toString();
            case "SUBTRACT":
                return "Subtraction Result: " + poly1.subtract(poly2).toString();
            case "MULTIPLY":
                return "Multiplication Result: " + poly1.multiply(poly2).toString();
            case "MUL_SCAL":
                double scalar = Double.parseDouble(parts[1]);
                return "Scalar Multiplication Result for poly1: " + poly1.multiplyByScalar(scalar).toString() +
                        "\nScalar Multiplication Result for poly2: " + poly2.multiplyByScalar(scalar).toString();
            case "EVAL":
                double x = Double.parseDouble(parts[1]);
                return "Evaluation of poly1 at x=" + x + ": " + poly1.evaluate(x) +
                        "\nEvaluation of poly2 at x=" + x + ": " + poly2.evaluate(x);
            default:
                return "Unknown command: " + command;
        }
    }
}
