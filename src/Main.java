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
            System.out.print("Lựa chọn (0-3): ");
            menu = Integer.parseInt(sc.nextLine());
            switch (menu) {
                case 1:
                    app.dangNhap();
                    break;
                case 2:
                    System.out.println("Bạn muốn tạo tài khoản cho vai trò gì?");
                    System.out.println("1. Sinh Viên.");
                    System.out.println("2. Thủ Thư.");
                    System.out.println("3. Quản Lý.");
                    System.out.println("4. Thoát.");
                    System.out.print("Lựa chọn (1 - 4): ");
                    int choice = Integer.parseInt(sc.nextLine());
                    app.dangKy(choice);
                    break;
                case 3:
                    app.timMK();
                    break;
            }
        } while (menu != 0);
    }
}
