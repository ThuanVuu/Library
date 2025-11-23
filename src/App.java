import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class App {
    Scanner sc = new Scanner(System.in);

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

    public void timKiem()
    {

    }

    public void them()
    {
        int chon;
        System.out.print("1-Sinh Viên \n 2-Thủ Thư \n 3-Sách");
        System.out.print("Hãy chọn đối tượng để thêm: ");
        chon = Integer.parseInt(sc.nextLine());
        switch(chon)
        {
            case 1:
                // đọc file sv
                SinhVien sv = new SinhVien();
                sv.NhapTT();
                danhSachSV.add(sv);
                //lưu file
                break;
            case 2:
                //đọc file thủ thư
                ThuThu tt = new ThuThu();
                tt.NhapTT();
                danhSachTT.add(tt);
                //lưu file
                break;
            case 3:
                //đọc file sách
                Sach s = new Sach();
                s.nhapTT();
                khoSach.add(s);
                //lưu file
                break;
            default:
                System.out.print("Lựa Chọn ko hợp lệ ");
                break;
        }
    }

    public void xoa()
    {
        int chon;
        System.out.print("1-Sinh Viên \n 2-Thủ Thư \n 3-Sách");
        System.out.print("Hãy chọn đối tượng để xóa: ");
        chon = Integer.parseInt(sc.nextLine());
        switch(chon)
        {
            case 1:
                //đọc file
                System.out.print("Hãy nhập tên cần xóa: ");
                String tenCanXoa = sc.nextLine();
                for(SinhVien sv : danhSachSV)
                {
                    if(sv.getTen().equalsIgnoreCase(tenCanXoa))
                    {
                        danhSachSV.remove(sv);
                        System.out.print("Đã xóa Thành Công!!!");
                        break;
                    }
                }
                break;
            case 2:
                //đọc file
                System.out.print("Hãy nhập tên cần xóa: ");
                String tenTTCanXoa = sc.nextLine();
                for(ThuThu tt : danhSachTT)
                {
                    if(tt.getTen().equalsIgnoreCase(tenTTCanXoa))
                    {
                        danhSachTT.remove(tt);
                        System.out.print("Đã xóa Thành Công!!!");
                        break;
                    }
                }
                break;
            case 3:
                //đọc file
                System.out.print("Hãy nhập tên sách cần xóa: ");
                String tenSCanXoa = sc.nextLine();
                for(Sach s : khoSach)
                {
                    if(s.getTenSach().equalsIgnoreCase(tenSCanXoa))
                    {
                        khoSach.remove(s);
                        System.out.print("Đã xóa Thành Công!!!");
                        break;
                    }
                }
                break;
            default:
                System.out.print("Lựa Chọn ko hợp lệ ");
                break;
        }
    }

    public void sua()
    {

    }


}
