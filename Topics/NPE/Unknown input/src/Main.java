import java.util.Objects;

class Util {
    // correct this method to avoid NPE
    public static void printLength(String name) {
        String s = null;
        if (Objects.equals(name,s)){
            System.out.println("name 未赋值");
        }else {
            System.out.println(name.length());
        }

    }
}