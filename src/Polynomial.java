public class Polynomial {
    private double[] coefficients;

    public Polynomial(double[] coefficients) {
        this.coefficients = coefficients;
    }

    public double[] getCoefficients() {
        return coefficients;
    }

    public Polynomial add(Polynomial other) {
        int maxLength = Math.max(this.coefficients.length, other.coefficients.length);
        double[] result = new double[maxLength];

        for (int i = 0; i < maxLength; i++) {
            double coef1 = i < this.coefficients.length ? this.coefficients[this.coefficients.length - 1 - i] : 0;
            double coef2 = i < other.coefficients.length ? other.coefficients[other.coefficients.length - 1 - i] : 0;
            result[maxLength - 1 - i] = coef1 + coef2;
        }

        return new Polynomial(result);
    }

    public Polynomial subtract(Polynomial other) {
        int maxLength = Math.max(this.coefficients.length, other.coefficients.length);
        double[] result = new double[maxLength];

        for (int i = 0; i < maxLength; i++) {
            double coef1 = i < this.coefficients.length ? this.coefficients[this.coefficients.length - 1 - i] : 0;
            double coef2 = i < other.coefficients.length ? other.coefficients[other.coefficients.length - 1 - i] : 0;
            result[maxLength - 1 - i] = coef1 - coef2;
        }

        return new Polynomial(result);
    }

    public Polynomial multiply(Polynomial other) {
        int newLength = this.coefficients.length + other.coefficients.length - 1;
        double[] result = new double[newLength];

        for (int i = 0; i < this.coefficients.length; i++) {
            for (int j = 0; j < other.coefficients.length; j++) {
                result[i + j] += this.coefficients[i] * other.coefficients[j];
            }
        }

        return new Polynomial(result);
    }

    public Polynomial multiplyByScalar(double scalar) {
        double[] result = new double[this.coefficients.length];

        for (int i = 0; i < this.coefficients.length; i++) {
            result[i] = this.coefficients[i] * scalar;
        }

        return new Polynomial(result);
    }

    public double evaluate(double x) {
        double result = 0;
        int degree = this.coefficients.length - 1;

        for (int i = 0; i < this.coefficients.length; i++) {
            result += this.coefficients[i] * Math.pow(x, degree - i);
        }

        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        int degree = coefficients.length - 1;

        for (int i = 0; i < coefficients.length; i++) {
            if (coefficients[i] != 0) {
                if (sb.length() > 0 && coefficients[i] > 0) {
                    sb.append(" + ");
                } else if (coefficients[i] < 0) {
                    sb.append(" - ");
                }

                double absCoefficient = Math.abs(coefficients[i]);
                if (absCoefficient != 1 || degree - i == 0) {
                    sb.append(absCoefficient);
                }

                if (degree - i > 0) {
                    sb.append("x");
                    if (degree - i > 1) {
                        sb.append("^").append(degree - i);
                    }
                }
            }
        }
        if (sb.length() == 0) {
            return "0";
        }
        return sb.toString();
    }
}
