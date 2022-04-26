package cinema;

import java.util.Scanner;

public class Cinema {
    public static void seatsLayout(int rowNum, int colNum) {
        String[][] matrix = new String[rowNum + 1][colNum + 1];
        System.out.println("Cinema:");
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                if (i == 0) {
                    matrix[i][j] = String.valueOf(j); // 赋值第一行的座位列数字
                }
                if (j < matrix.length) {
                    matrix[j][0] = String.valueOf(i + 1); // 每行第一列赋值，这就为打印下一行起始列服务的
                }
                if (i != 0 && j != 0) {
                    matrix[i][j] = "S";
                }
                if (j == 0 && i == 0) {
                    matrix[i][0] = " ";
                }
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static int soldTickets(int rows, int seats) {
        int limit = 60;
        int totalSeats = rows * seats;
        int seatPrice = 10;
        int frontPrice = 10;
        int backPrice = 8;
        int frontRows;
        int backRows;
        int result;
        if (totalSeats <= limit) {
            result = totalSeats * seatPrice;
        } else {
            if (rows % 2 == 0) {
                frontRows = rows / 2;
                backRows = rows / 2;
            } else {
                frontRows = (rows / 2);
                backRows = (rows / 2) + 1;
            }
            result = seats * ((frontPrice * frontRows) + (backPrice * backRows));

        }

        return result;

//        System.out.println("Total income:\n$" + result);

    }

    public static void main(String[] args) {
        // Write your code here
        Scanner scanner = new Scanner(System.in);

        // 初次运行，展示座位布局
        System.out.println("Enter the number of rows:");
        int rowNum = scanner.nextInt();
        System.out.println("Enter the number of seats in each row:");
        int colNum = scanner.nextInt();

        // 定义全部座位和已购买座位数
        int totalSeatsNum = rowNum * colNum;
        int seatsSoldNum = 0;

        // 收入情况
        int totalIncome = soldTickets(rowNum, colNum);
        int currentIncome = 0;

        // 座位表相关
        String[][] seatArrays;
        int[][] seatSolded = new int[rowNum][colNum];


        seatArrays = seatsLayout3(rowNum, colNum); // 定义原始座位布局
        boolean flag = true;
        while (flag) {
            //  展示菜单
            showMenu();

            int item = scanner.nextInt();

            switch (item) {
                case 1: {
                    // 1. 展示座位
                    showLayout(seatArrays);
                    break;
                }
                case 2: {
                    // 2. 选择并购买座位,如果选错需要继续选
                    boolean flag2 = true;
                    while (flag2) {
                        System.out.println("Enter a row number:");
                        int row = scanner.nextInt();
                        System.out.println("Enter a seat number in that row:");
                        int seat = scanner.nextInt();

                        if (row > rowNum || seat > colNum) {
                            System.out.println("Wrong input!");
                        } else {
                            if (seatSolded[row - 1][seat - 1] == 0) {
                                seatArrays = chooseSeat(rowNum, colNum, row, seat, seatArrays);
                                seatSolded[row - 1][seat - 1] = 1;
                                seatsSoldNum += 1;
                                int income = soldTicket(rowNum, colNum, row, seat);
                                currentIncome += income;
                                flag2 = false;
                            } else {
                                System.out.println("That ticket has already been purchased!");
                            }
                        }
                    }
                    break;

                }
                case 3: {
                    // 3. 统计数据
                    showStatistics(totalSeatsNum, seatsSoldNum, totalIncome, currentIncome);
                    break;
                }
                case 0: {
                    // 3. 退出
                    flag = false;
                    break;
                }
            }

        }

    }

    private static void showStatistics(int totalSeatsNum, int seatsSoldNum, int totalIncome, int currentIncome) {
        // 此函数计算统计数据
        String percentSym = "%";
        System.out.printf("Number of purchased tickets: %d\n", seatsSoldNum);
        double percent = (double) seatsSoldNum / (double) totalSeatsNum * 100;

        System.out.printf("Percentage: %.2f%s\n", percent, percentSym);
        System.out.printf("Current income: $%d\n", currentIncome);
        System.out.printf("Total income: $%d\n", totalIncome);


    }

    // 展示座位排列
    private static void showLayout(String[][] seatArrays) {
        System.out.println("Cinema:");
        for (int i = 0; i < seatArrays.length; i++) {
            for (int j = 0; j < seatArrays[i].length; j++) {
                System.out.print(seatArrays[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println();
    }

    // 定义初始座位排列
    private static String[][] seatsLayout3(int rowNum, int colNum) {
        String[][] matrix = new String[rowNum + 1][colNum + 1];
        for (int i = 1; i < matrix.length; i++) {
            matrix[i][0] = String.valueOf(i);
        }

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                if (i == 0) {
                    matrix[i][j] = String.valueOf(j); // 赋值第一行的座位列数字
                }
                if (i != 0 && j != 0) {
                    matrix[i][j] = "S";
                }
                if (j == 0 && i == 0) {
                    matrix[i][0] = " ";
                }
            }
        }

        return matrix;

    }

    // 选择座位
    private static String[][] chooseSeat(int rowNum, int colNum, int row, int seat, String[][] seatArrays) {
        soldTicket(rowNum, colNum, row, seat);
        seatArrays[row][seat] = "B";
        return seatArrays;
    }

    // 显示菜单
    private static void showMenu() {
        System.out.println("1. Show the seats");
        System.out.println("2. Buy a ticket");
        System.out.println("3. Statistics");
        System.out.println("0. Exit");
    }

    private static void seatsLayout2(int rowNum, int colNum, int row, int col) {

        String[][] matrix = new String[rowNum + 1][colNum + 1];
        System.out.println("Cinema:");
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                if (i == 0) {
                    matrix[i][j] = String.valueOf(j);
                }
                if (j < matrix.length) {
                    matrix[j][0] = String.valueOf(i + 1);
                }
                if (i != 0 && j != 0) {
                    if (i == row && j == col) {
                        matrix[i][j] = "B";
                    } else {
                        matrix[i][j] = "S";
                    }

                }
                if (j == 0 && i == 0) {
                    matrix[i][0] = " ";
                }
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }

    }

    private static int soldTicket(int rows, int seats, int row, int seat) {
        int limit = 60;
        int totalSeats = rows * seats;
        int seatPrice = 10;
        int frontPrice = 10;
        int backPrice = 8;
        int frontRows;
        int backRows;
        int result;
        if (totalSeats <= limit) {
            result = seatPrice;
        } else {
            if (rows % 2 == 0) {
                frontRows = rows / 2;
                backRows = rows / 2;
            } else {
                frontRows = (rows / 2);
                backRows = (rows / 2) + 1;
            }
            if (row <= frontRows) {
                result = frontPrice;
            } else {
                result = backPrice;
            }

        }
        System.out.println("Ticket price: $" + result);
        return result;
    }
}