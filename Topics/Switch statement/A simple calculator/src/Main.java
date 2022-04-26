import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        // start coding here
        Long firstNum = scanner.nextLong();
        char operator = scanner.next().charAt(0);
        Long secondNum = scanner.nextLong();
        Long result = 0L;
        switch (operator) {
            case '+': {
                result = firstNum + secondNum;
                System.out.println(result);
                break;
            }
            case '-': {
                result = firstNum - secondNum;
                System.out.println(result);
                break;
            }
            case '*': {
                result = firstNum * secondNum;
                System.out.println(result);
                break;

            }
            case '/': {
                if (secondNum == 0) {
                    System.out.println("Division by 0!");
                    break;
                } else {
                    result = firstNum / secondNum;
                    System.out.println(result);
                    break;
                }

            }
            default:
                System.out.println("Unknown operator");
        }

    }
}