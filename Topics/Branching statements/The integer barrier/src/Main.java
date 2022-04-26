import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        // start coding here
        int sumVal = 0;
        while (scanner.hasNext()){
            int elem = scanner.nextInt();
            sumVal += elem;
            if (elem ==0 || sumVal >= 1000){
                break;
            }
        }
        int outVal = sumVal>=1000? sumVal-1000:sumVal;
        System.out.println(outVal);
    }
}