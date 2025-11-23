import java.io.*;
import java.util.Scanner;

public class TaiKhoan {

    Scanner sc = new Scanner(System.in);

    private String taiKhoan;
    private String matKhau;
    private String role;

    public TaiKhoan() {

    }

    public TaiKhoan(String taiKhoan, String matKhau, String role) {
        this.setTaiKhoan(taiKhoan);
        this.setMatKhau(matKhau);
        this.setRole(role);
    }

    public void taoTK() {
        System.out.print("Nhập tên tài khoản: ");
        this.setTaiKhoan(sc.nextLine());
        System.out.print("Nhập mật khẩu: ");
        this.setMatKhau(sc.nextLine());
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

    public String toString() {
        return taiKhoan + " - " + matKhau + " - " + role;
    }

    public void saveToFile(String filePath, boolean choice) {
        File file = new File(filePath);
        try {
            FileWriter fw = new FileWriter(file, choice);
            PrintWriter pw = new PrintWriter(fw);
            pw.println(this);
            fw.close();
            pw.close();
        } catch (Exception e) {
            System.out.println("Lỗi: " + e.getMessage());
        }
    }

    public static void addFromFile(String filepath) {
        File file = new File(filepath);
        try {
            FileReader fr = new FileReader(file);
            BufferedReader br = new BufferedReader(fr);

            String line;

            while ((line = br.readLine()) != null) {
                String arr[] = line.split(" - ");
                try {
                    String taiKhoan = arr[0].trim();
                    String matKhau = arr[1].trim();
                    String role = arr[2].trim();

                    TaiKhoan tk = new TaiKhoan(taiKhoan, matKhau, role);
                    App.danhSachTK.add(tk);
                } catch (Exception e) {
                    System.out.println(e.getMessage());
                }
            }
            fr.close();
            br.close();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
