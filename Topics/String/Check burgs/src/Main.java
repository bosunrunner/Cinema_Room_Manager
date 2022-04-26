import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        // start coding here
        String cityName = scanner.nextLine(); // 输入整行
        System.out.println(cityName.endsWith("burg"));
    }
}