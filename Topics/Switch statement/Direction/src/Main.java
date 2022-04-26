import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        // start coding here
        int val = scanner.nextInt();
        String motion = "";
        switch (val) {
            case 1:
                motion = "move up";
                break;
            case 2:
                motion = "move down";
                break;
            case 3:
                motion = "move left";
                break;
            case 4:
                motion = "move right";
                break;
            case 0:
                motion = "do not move";
                break;
            default:
                motion = "error!";
        }
        System.out.println(motion);


    }
}