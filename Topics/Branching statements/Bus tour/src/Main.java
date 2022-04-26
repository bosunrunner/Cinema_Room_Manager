import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // start coding here
        int busHeight = scanner.nextInt();
        int bridgeNum = scanner.nextInt();
        int jishu = 0;
        for (int i=1;i<=bridgeNum;i++){
            int elemHeight = scanner.nextInt();

            if (busHeight>=elemHeight){
                System.out.println("Will crash on bridge "+i);
                break;
            }
            jishu++;
        }
        if (jishu==bridgeNum){
            System.out.println("Will not crash");
        }

    }
}