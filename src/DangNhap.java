import java.util.Scanner;

public class DangNhap {

    Scanner sc = new Scanner(System.in);

    private String taiKhoan;
    private String matKhau;

    public DangNhap() {

    }

    public void DangKy() {
        System.out.print("Nhập tên tài khoản: ");
        this.setTaiKhoan(sc.nextLine());
        System.out.print("Nhập mật khẩu: ");
        this.setMatKhau(sc.nextLine());
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
