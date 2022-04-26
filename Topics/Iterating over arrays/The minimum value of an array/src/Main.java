import java.util.Arrays;
import java.util.OptionalInt;
import java.util.Scanner;
import java.util.stream.IntStream;

class Main {
    public static void main(String[] args) {
        // put your code here
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] arrays = new int[n];
        for (int i = 0; i < n; i++) {
            int elem = scanner.nextInt();
            arrays[i] = elem;
        }
        int result = IntStream.of(arrays).min().getAsInt();
        System.out.println(result);

    }
}