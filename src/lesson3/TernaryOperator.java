package lesson3;

public class TernaryOperator {
    public static void main(String[] args) {
        int a;
        byte b = 100;

        /*if (b > 200)
            a = 500;
        else
            a = 350;*/

        a = b > 200 ? b : b-500;
        System.out.println(a);
    }
}
