import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        // start coding here
        String shape = scanner.next();
        final String juXing = "rectangle";
        final String yuanXing = "circle";
        final String sanJaoXing = "triangle";
        double mianJi = 0;
        switch (shape) {
            case juXing: {
                double a = scanner.nextDouble();
                double b = scanner.nextDouble();
                mianJi = a * b;
                break;
            }
            case yuanXing: {
                double r = scanner.nextDouble();
                mianJi = 3.14 * Math.pow(r, 2);
                break;
            }
            case sanJaoXing: {
                double a = scanner.nextDouble();
                double b = scanner.nextDouble();
                double c = scanner.nextDouble();
                double d = (a + b + c) / 2;
                mianJi = Math.sqrt(d * (d - a) * (d - b) * (d - c));
                break;
            }
        }
        System.out.println(mianJi);
    }
}