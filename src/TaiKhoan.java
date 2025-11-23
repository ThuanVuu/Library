import java.util.Scanner;

public class TaiKhoan {

    Scanner sc = new Scanner(System.in);

    private String taiKhoan;
    private String matKhau;
    private String role;

    public TaiKhoan() {

    }

    public void dangKy() {
        System.out.print("Nhập tên tài khoản: ");
        this.setTaiKhoan(sc.nextLine());
        System.out.print("Nhập mật khẩu: ");
        this.setMatKhau(sc.nextLine());
        System.out.print("Nhập vai trò: ");
        this.setRole(sc.nextLine());
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getTaiKhoan() {
        return taiKhoan;
    }

    public void setTaiKhoan(String taiKhoan) {
        this.taiKhoan = taiKhoan;
    }

    public String getMatKhau() {
        return matKhau;
    }

    public void setMatKhau(String matKhau) {
        this.matKhau = matKhau;
    }
}
