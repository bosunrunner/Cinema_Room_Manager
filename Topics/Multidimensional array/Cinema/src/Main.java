import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        // put your code here
        Scanner scanner = new Scanner(System.in);

        int row = scanner.nextInt();
        int col = scanner.nextInt();
        int[][] cinema = new int[row][col];
        // 根据输入搭建座位表
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                cinema[i][j] = scanner.nextInt();
            }
        }
        int k = scanner.nextInt();
        int shuChuRow = 0;

        // 找到连续空座位超过k的行
        for (int i = 0; i < row; i++) {
            int count = 0;
            for (int j = 0; j < col; j++) {
                if (cinema[i][j] == 0) {
                    count++;
                } else {
                    count = 0;
                }
                if (count >= k) {
                    break;
                }
            }
            if (count >= k) {
                shuChuRow = i + 1;
                break;
            }
        }
        System.out.println(shuChuRow);

    }
}