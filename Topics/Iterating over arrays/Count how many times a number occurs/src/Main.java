import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        // put your code here
        // put your code here
        Scanner scanner = new Scanner(System.in);
        int numInput = scanner.nextInt();
        int[] arrayNum = new int[numInput];
        int sumNUm = 0;
        for (int i = 0; i < numInput; i++) {
            int elem = scanner.nextInt();
            arrayNum[i] = elem;
        }
        int shuzi = scanner.nextInt();
        for (int elem : arrayNum) {
            if (elem == shuzi) {
                sumNUm += 1;
            }
        }
        System.out.println(sumNUm);

    }
}