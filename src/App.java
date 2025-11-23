import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class App {
    Scanner sc = new Scanner(System.in);

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
        System.out.println("Bạn muốn tạo tài khoản cho vai trò gì?");
        System.out.println("1. Sinh Viên.");
        System.out.println("2. Thủ Thư.");
        System.out.println("3. Quản Lý.");
        System.out.print("Lựa chọn (1 - 3): ");
        int choice = Integer.parseInt(sc.nextLine());
        switch (choice) {
            case 1:
                SinhVien sv = new SinhVien();
                sv.setRole("SinhVien");
                sv.taoTK();
                System.out.println("\n".repeat(100));
                sv.NhapTT();
                sv.saveToFile(fileTK, true);
                break;
            case 2:
                ThuThu tt = new ThuThu();
                tt.setRole("ThuThu");
                tt.taoTK();
                System.out.println("\n".repeat(100));
                tt.NhapTT();
                tt.saveToFile(fileTK, true);
                break;
            case 3:
                QuanLy ql = new QuanLy();
                ql.setRole("QuanLy");
                ql.taoTK();
                System.out.println("\n".repeat(100));
                ql.NhapTT();
                ql.saveToFile(fileTK, true);
                break;
        }
    }

    public void dangNhap() {
        System.out.print("Nhập tài khoản: ");
        String taiKhoan = sc.nextLine();
        boolean checkTK = false;
        System.out.print("Nhập mật khẩu: ");
        String matKhau = sc.nextLine();
        boolean checkMK = false;
        TaiKhoan dangnhap = null;

        int i = 0;
        //Kiem tra tai khoan va mat khau
        while (i < danhSachTK.size()) {
            TaiKhoan tk = danhSachTK.get(i);
            if (tk.getTaiKhoan().equals(taiKhoan)) {
                checkTK = true;
                if (tk.getMatKhau().equals(matKhau)) {
                    checkMK = true;
                }
            }
            if (checkMK && checkTK) {
                System.out.println("Đăng nhập thành công!!");
            }
            i++;
        }
        if (checkMK == false || checkTK == false) {
            System.out.println("Mật khẩu hoặc tài khoản không hợp lệ.");
        }
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
