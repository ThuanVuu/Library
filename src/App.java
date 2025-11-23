import java.util.ArrayList;
import java.util.List;

public class App {

    public static final String fileQL = "QuanLy.txt";
    public static final String fileSV = "SinhVien.txt";
    public static final String fileTT = "ThuThu.txt";
    public static final String fileSach = "KhoSach.txt";
    public static final String fileTK = "DangNhap.txt";

    List<QuanLy> danhSachQL = new ArrayList<>();
    List<SinhVien> danhSachSV = new ArrayList<>();
    List<ThuThu> danhSachTT = new ArrayList<>();
    List<Sach> khoSach = new ArrayList<>();
    List<TaiKhoan> danhSachTK = new ArrayList<>();

    public App() {

    }

    public void dangKy() {
        TaiKhoan tk = new TaiKhoan();
        tk.dangKy();
        danhSachTK.add(tk);
    }

    public void dangNhap() {

    }
}
