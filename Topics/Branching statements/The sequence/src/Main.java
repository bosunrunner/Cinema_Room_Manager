import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int count = scanner.nextInt();
        int limit = 0;
        for (int i = 1; i <= count; i++) {
            for (int j = 1; j <= i && limit < count; j++) {
                limit++;
                System.out.print(i + " ");
            }
        }
        scanner.close();
    }
}