import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        App app = new App();
        Scanner sc = new Scanner(System.in);
        int menu = 1;

        do {
            System.out.println("-----------------Login-----------------");
            System.out.println("0. Thoát");
            System.out.println("1. Đăng Nhập.");
            System.out.println("2. Đăng Ký.");
            System.out.println("3. Quên mật khẩu.");
            System.out.println("---------------------------------------");
            System.out.print("Lựa chọn (1-3): ");
            menu = Integer.parseInt(sc.nextLine());
            switch (menu) {
                case 1:

                case 2:
                case 3:
            }
        } while (menu != 0);
    }
}
