import java.io.File;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class App {

    public static final String fileQL = "QuanLy.txt";
    public static final String fileSV = "SinhVien.txt";
    public static final String fileTT = "ThuThu.txt";
    public static final String fileSach = "KhoSach.txt";
    public static final String fileTK = "DangNhap.txt";

    public static List<QuanLy> danhSachQL = new ArrayList<>();
    public static List<SinhVien> danhSachSV = new ArrayList<>();
    public static List<ThuThu> danhSachTT = new ArrayList<>();
    public static List<Sach> khoSach = new ArrayList<>();
    public static List<TaiKhoan> danhSachTK = new ArrayList<>();

    public App() {
        TaiKhoan.addFromFile(fileTK);
    }

    public void dangKy() {
        TaiKhoan tk = new TaiKhoan();
        tk.dangKy();
        danhSachTK.add(tk);
        tk.saveToFile(fileTK, true);
    }

    public void dangNhap() {

    }


}
