import java.io.FileWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class App {
    Scanner sc = new Scanner(System.in);

    public static final String fileSach = "KhoSach.txt";
    public static final String fileDaMuon = "SachMuon.txt";
    public static final String fileTK = "DangNhap.txt";
    public static final String fileDonMuon = "DonMuon.txt";

    public static List<QuanLy> danhSachQL = new ArrayList<>();
    public static List<SinhVien> danhSachSV = new ArrayList<>();
    public static List<ThuThu> danhSachTT = new ArrayList<>();
    public static List<Sach> khoSach = new ArrayList<>();
    public static List<TaiKhoan> danhSachTK = new ArrayList<>();
    public static List<DonMuonSach> donMuonSach = new ArrayList<>();


    public App() {
        TaiKhoan.addFromFile(fileTK);
        Sach.addFromFile(fileSach);
    }

    public void dangKy(int choice) {
        switch (choice) {
            case 1:
                SinhVien sv = new SinhVien();
                sv.setRole("SinhVien");
                sv.taoTK();
                System.out.println("\n".repeat(100));
                sv.NhapTT();
                sv.saveToFile(fileTK, true);
                danhSachTK.add(sv);
                danhSachSV.add(sv);
                sv.addFromFile(fileTK);
                break;
            case 2:
                ThuThu tt = new ThuThu();
                tt.setRole("ThuThu");
                tt.taoTK();
                System.out.println("\n".repeat(100));
                tt.NhapTT();
                tt.saveToFile(fileTK, true);
                tt.addFromFile(fileTK);
                danhSachTT.add(tt);
                danhSachTT.add(tt);
                break;
            case 3:
                QuanLy ql = new QuanLy();
                ql.setRole("QuanLy");
                ql.taoTK();
                System.out.println("\n".repeat(100));
                ql.NhapTT();
                ql.saveToFile(fileTK, true);
                ql.addFromFile(fileTK);
                danhSachQL.add(ql);
                danhSachTK.add(ql);
                break;
            default:
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
                switch(tk.getRole()) {
                    case "SinhVien":
                        boolean menu = true;
                        while (menu) {
                            System.out.println("----------------------Menu Chức Năng----------------------");
                            System.out.println("0. Thoát.");
                            System.out.println("1. Lập yêu cầu mượn sách.");
                            System.out.println("2. Lập yêu cầu trả sách.");
                            System.out.println("3. Xem thông tin phạt.");
                            System.out.println("4. Sửa thông tin cá nhân.");
                            System.out.println("5. Tìm kiếm sách.");
                            System.out.println("6. Nộp phạt.");
                            System.out.println("7. Kiểm tra phạt.");
                            System.out.println("----------------------------------------------------------");
                            System.out.print("Lựa chọn (0 - 7): ");
                            int choice = Integer.parseInt(sc.nextLine());
                            switch (choice) {
                                case 0:
                                    menu = false;
                                    break;
                                case 1:
                                    this.muonSach(tk.getTaiKhoan());
                                    break;
                                case 2:
                                case 3:
                                case 4:
                                case 5:
                                    System.out.print("Nhập tên sách: ");
                                    String tenSach = sc.nextLine();
                                    this.timKiemSach(tenSach);
                                    break;
                                case 6:
                                case 7:
                                default:
                                    System.out.println("Vui lòng nhập từ 0 - 7!!");
                                    break;
                            }
                        }
                        break;
                    case "ThuThu":
                        boolean menu2 = true;
                        while(menu2){
                            System.out.println("----------------------Menu Chức Năng----------------------");
                            System.out.println("0. Thoát.");
                            System.out.println("1. Thêm Sách.");
                            System.out.println("2. Sửa Sách.");
                            System.out.println("3. Xóa Sách");
                            System.out.println("4. Quản Lý Danh Mục Sách.");
                            System.out.println("5. Thêm Thông Tin Sinh Viên.");
                            System.out.println("6. Xóa Thông Tin Sinh Viên.");
                            System.out.println("7. Sửa Thông Tin Sinh Viên.");
                            System.out.println("8. Tìm Kiếm Sách.");
                            System.out.println("----------------------------------------------------------");
                            System.out.print("Lựa chọn (0 - 8): ");
                            int choice2 = Integer.parseInt(sc.nextLine());
                            switch (choice2) {
                                case 0:
                                    menu2 = false;
                                    break;
                                case 1:
                                    this.themSach();
                                    break;
                                case 2:
                                    this.suaSach(locSachTheoTen());
                                    break;
                                case 3:
                                    this.xoaSach(locSachTheoTen());
                                    break;
                                case 4:
                                case 5:
                                    this.dangKy(1);
                                    break;
                                case 6:
                                case 7:
                                case 8:
                                    System.out.print("Nhập tên sách: ");
                                    String tenSach = sc.nextLine();
                                    this.timKiemSach(tenSach);
                                    break;
                                default:
                                    System.out.println("Vui lòng nhập từ 0 - 8!!");
                                    break;
                            }
                        }
                        break;
                    case "QuanLy":
                        boolean menu3 = true;
                        while(menu3){
                            System.out.println("----------------------Menu Chức Năng----------------------");
                            System.out.println("0. Thoát.");
                            System.out.println("1. Thêm Sách.");
                            System.out.println("2. Sửa Sách.");
                            System.out.println("3. Xóa Sách");
                            System.out.println("4. Thêm Thông Tin Sinh Viên.");
                            System.out.println("5. Xóa Thông Tin Sinh Viên.");
                            System.out.println("6. Sửa Thông Tin Sinh Viên.");
                            System.out.println("7. Thêm Thông Tin Thủ Thư.");
                            System.out.println("8. Xóa Thông Tin Thủ Thư.");
                            System.out.println("9. Sửa Thông Tin Thủ Thư.");
                            System.out.println("10. Tìm Kiếm Sách.");
                            System.out.println("----------------------------------------------------------");
                            System.out.print("Lựa chọn (0 - 10): ");
                            int choice3 = Integer.parseInt(sc.nextLine());
                            switch (choice3) {
                                case 0:
                                    menu3 = false;
                                    break;
                                case 1:
                                    this.themSach();
                                    break;
                                case 2:
                                    this.suaSach(locSachTheoTen());
                                    break;
                                case 3:
                                    this.xoaSach(locSachTheoTen());
                                    break;
                                case 4:
                                    this.dangKy(1);
                                    break;
                                case 5:
                                    this.xoa(1);
                                    break;
                                case 6:
                                case 7:
                                    this.dangKy(2);
                                    break;
                                case 8:
                                    this.xoa(2);
                                    break;
                                case 9:
                                case 10:
                                    System.out.print("Nhập tên sách: ");
                                    String tenSach = sc.nextLine();
                                    this.timKiemSach(tenSach);
                                    break;
                                default:
                                    System.out.println("Vui lòng nhập từ 0 - 10!!");
                                    break;
                            }
                        }
                        break;
                }
                break;
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

    public int locTheoTen(String name, ArrayList<TaiKhoan> list, int chon) {
        int count = 0;

        switch(chon) {
            case 1:
                for (SinhVien sv : danhSachSV) {
                    if (sv.getTen().toLowerCase().contains(name)) {
                        list.add(sv);
                        count++;
                    }
                }
                break;
            case 2:
                for (ThuThu tt : danhSachTT) {
                    if (tt.getTen().toLowerCase().contains(name)) {
                        list.add(tt);
                        count++;
                    }
                }
                break;
            case 3:
                for (QuanLy ql : danhSachQL) {
                    if (ql.getTen().toLowerCase().contains(name)) {
                        list.add(ql);
                        count++;
                    }
                }
                break;
        }
        return count;
    }

    public void xoa(int chon)
    {
        ArrayList<TaiKhoan> danhSachLoc = new ArrayList<>();

        switch(chon)
        {
            case 1:
                //đọc file
                System.out.print("Hãy nhập tên cần xóa: ");
                String tenCanXoa = sc.nextLine();
                this.locTheoTen(tenCanXoa, danhSachLoc, 1);
                for (int i = 0; i < danhSachLoc.size(); i++) {
                    System.out.println((i + 1) + ". " + danhSachLoc.get(i));
                }
                System.out.print("Chọn đối tượng cần xoá: ");
                int i = Integer.parseInt(sc.nextLine());
                for (SinhVien sv : danhSachSV) {
                    if (sv.getTaiKhoan().equals(danhSachLoc.get(i - 1).getTaiKhoan())) {
                        danhSachSV.remove(sv);
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

    public void timMK() {
        System.out.print("Nhập Tài Khoản Cần Tìm MK: ");
        String tenTkCanTim = sc.nextLine();

        System.out.print("Bạn muốn tìm bằng Email hay SDT (1-Email, 2-SDT): ");
        int chon = Integer.parseInt(sc.nextLine());

        System.out.print("Bạn là: 1-Sinh Viên 2-Thủ Thư 3-Quản Lý: ");
        int vaitro = Integer.parseInt(sc.nextLine());

        boolean found = false;

        switch (chon) {
            case 1:
                System.out.print("Nhập Email: ");
                String email = sc.nextLine();

                switch (vaitro) {
                    case 1:
                        for (SinhVien sv : danhSachSV) {
                            if (sv.getEmail().equalsIgnoreCase(email)) {

                                for (TaiKhoan tk : danhSachTK) {
                                    if (tk.getTaiKhoan().equalsIgnoreCase(tenTkCanTim)) {
                                        System.out.println("Mật khẩu là: " + tk.getMatKhau());
                                        found = true;
                                        break;
                                    }
                                }
                                break;
                            }
                        }
                        if (!found) {
                            System.out.println("Không có tài khoản này");
                        }
                        break;

                    case 2:
                        for (ThuThu tt : danhSachTT) {
                            if (tt.getEmail().equalsIgnoreCase(email)) {

                                for (TaiKhoan tk : danhSachTK) {
                                    if (tk.getTaiKhoan().equalsIgnoreCase(tenTkCanTim)) {
                                        System.out.println("Mật khẩu là: " + tk.getMatKhau());
                                        found = true;
                                        break;
                                    }
                                }
                                break;
                            }
                        }
                        if (!found) {
                            System.out.println("Không có tài khoản này");
                        }
                        break;

                    case 3:
                        for (QuanLy ql : danhSachQL) {
                            if (ql.getEmail().equalsIgnoreCase(email)) {

                                for (TaiKhoan tk : danhSachTK) {
                                    if (tk.getTaiKhoan().equalsIgnoreCase(tenTkCanTim)) {
                                        System.out.println("Mật khẩu là: " + tk.getMatKhau());
                                        found = true;
                                        break;
                                    }
                                }
                                break;
                            }
                        }
                        if (!found) {
                            System.out.println("Không có tài khoản này");
                        }
                        break;

                    default:
                        System.out.println("Không hợp lệ!");
                }
                break;
            case 2:
                System.out.print("Hãy Nhập SĐT: ");
                String sdtCanTim = sc.nextLine();

                switch (vaitro) {
                    case 1:
                        for (SinhVien sv : danhSachSV) {
                            if (sv.getSDT().equalsIgnoreCase(sdtCanTim)) {

                                for (TaiKhoan tk : danhSachTK) {
                                    if (tk.getTaiKhoan().equalsIgnoreCase(tenTkCanTim)) {
                                        System.out.println("Mật khẩu: " + tk.getMatKhau());
                                        found = true;
                                        break;
                                    }
                                }
                                break;
                            }
                        }
                        if (!found) {
                            System.out.println("Tài khoản hoặc số không tồn tại");
                        }
                        break;

                    case 2:
                        for (ThuThu tt : danhSachTT) {
                            if (tt.getSDT().equalsIgnoreCase(sdtCanTim)) {

                                for (TaiKhoan tk : danhSachTK) {
                                    if (tk.getTaiKhoan().equalsIgnoreCase(tenTkCanTim)) {
                                        System.out.println("Mật khẩu: " + tk.getMatKhau());
                                        found = true;
                                        break;
                                    }
                                }
                                break;
                            }
                        }
                        if (!found) {
                            System.out.println("Tài khoản hoặc số không tồn tại");
                        }
                        break;

                    case 3:
                        for (QuanLy ql : danhSachQL) {
                            if (ql.getSDT().equalsIgnoreCase(sdtCanTim)) {

                                for (TaiKhoan tk : danhSachTK) {
                                    if (tk.getTaiKhoan().equalsIgnoreCase(tenTkCanTim)) {
                                        System.out.println("Mật khẩu: " + tk.getMatKhau());
                                        found = true;
                                        break;
                                    }
                                }
                                break;
                            }
                        }
                        if (!found) {
                            System.out.println("Tài khoản hoặc số không tồn tại");
                        }
                        break;
                }
                break;

            default:
                System.out.println("Lựa chọn không hợp lệ!");
        }
    }
    public void timTenTK()
    {
        System.out.print("Hãy nhập tên Tài Khoản bạn muốn tìm: ");
        String ten = sc.nextLine();
        System.out.print("Bạn là: 1-Sinh Viên 2-Thủ Thư 3-Quản Lý");
        int chon = Integer.parseInt(sc.nextLine());
        boolean tim= false;
        switch(chon)
        {
            case 1:
                for(SinhVien sv : danhSachSV)
                {
                    if(sv.getTaiKhoan().equalsIgnoreCase(ten))
                    {
                        System.out.println("Tìm Thấy tài khoản:");
                        sv.Xuat();
                        tim = true;
                        break;
                    }
                }
                if(!tim)
                {
                    System.out.print("Không thấy tài khoản");
                }
                break;
            case 2:
                for(ThuThu tt : danhSachTT)
                {
                    if(tt.getTaiKhoan().equalsIgnoreCase(ten))
                    {
                        System.out.println("Tìm thấy tài khoản:");
                        tt.Xuat();
                        tim = true;
                        break;
                    }
                }
                if(!tim)
                {
                    System.out.print("Không thấy tài khoản");
                }
                break;
            case 3:
                for(QuanLy ql: danhSachQL)
                {
                    if(ql.getTaiKhoan().equalsIgnoreCase(ten))
                    {
                        System.out.println("Tìm thấy tài khoản:");
                        ql.Xuat();
                        tim = true;
                        break;
                    }
                }
                if(!tim)
                {
                    System.out.print("Không thấy tài khoản");
                }
                break;
        }
    }

    public void themSach() {
        Sach sach = new Sach();
        sach.nhapTT();
        sach.saveToFile(fileSach, true);
    }

    public void updateSach() {
        try {
            FileWriter writer = new FileWriter(fileSach);
            writer.close();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        for (Sach s : khoSach) {
            s.saveToFile(fileSach, true);
        }
    }

    public void updateTK() {
        try {
            FileWriter writer = new FileWriter(fileTK);
            writer.close();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        for (TaiKhoan tk : danhSachTK) {
            tk.saveToFile(fileTK, true);
        }
    }

    public void inSach() {
        for (int i = 0; i < khoSach.size(); i++) {
            System.out.println(khoSach.get(i));
        }
    }

    public void suaSach(String name) {
        for (Sach s : khoSach) {
            if (s.getTenSach().equalsIgnoreCase(name)) {
                System.out.println("Bạn muốn sửa phần nào?");
                System.out.println("0. Thoát.");
                System.out.println("1. Tên sách.");
                System.out.println("2. Tên tác giả.");
                System.out.println("3. Ngày xuất bản.");
                System.out.println("4. Mã sách.");
                System.out.print("Nhập số để chọn chức năng (1 - 4): ");
                int choice = Integer.parseInt(sc.nextLine());
                switch(choice) {
                    case 1:
                        System.out.print("Nhập tên sách mới: ");
                        String tenMoi = sc.nextLine();
                        s.setTenSach(tenMoi);
                        break;
                    case 2:
                        System.out.print("Nhập tên tác giả mới: ");
                        String tgMoi = sc.nextLine();
                        s.setTacGia(tgMoi);
                        break;
                    case 3:
                        System.out.print("Nhập ngày xuất bản mới: ");
                        s.setNgayXB();
                        break;
                    case 4:
                        System.out.print("Nhập mã sách mới: ");
                        int maMoi = Integer.parseInt(sc.nextLine());
                        s.setMaSach(maMoi);
                        break;
                    default:
                        break;
                }
            }
        }
        this.updateSach();
    }

    public void xoaSach(String name) {
        for (Sach s : khoSach) {
            if (s.getTenSach().equalsIgnoreCase(name)) {
                khoSach.remove(s);
                System.out.println("Đã xoá!!");
            }
        }
        this.updateSach();
    }



    public String locSachTheoTen() {
        ArrayList<Sach> arr = new ArrayList<>();

        System.out.print("Nhập tên: ");
        String ten = sc.nextLine();
        for (Sach s : khoSach) {
            if (s.getTenSach().toLowerCase().contains(ten.toLowerCase())) {
                arr.add(s);
            }
        }

        System.out.println("Danh sách cùng tên: ");
        for (int i = 0; i < arr.size() - 1; i++) {
            System.out.println((i + 1) + ". " + arr.get(i).getTenSach());
        }
        System.out.print("Bạn chọn sách nào: ");
        int choice = Integer.parseInt(sc.nextLine());

        return arr.get(choice - 1).getTenSach();
    }

    public void timKiemSach(String name) {
        System.out.println("\n".repeat(100));
        System.out.println("Danh sách cùng tên: ");
        for (Sach s : khoSach) {
            if (s.getTenSach().toLowerCase().contains(name.toLowerCase())) {
                System.out.println(s);
            }
        }
        try {
            Thread.sleep(5000);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public void ThemSV()
    {
        SinhVien sv = new SinhVien();
        sv.NhapTT();
        danhSachSV.add(sv);
        danhSachTK.add(sv);
        sv.saveToFile(fileTK , true);
    }
    public void XoaSV()
    {
        System.out.print("Hãy nhập tên sinh viên muốn xóa: ");
        String tencanxoa = sc.nextLine();
        for(SinhVien sv : danhSachSV)
        {
            if(sv.getTen().equalsIgnoreCase(tencanxoa))
            {
                danhSachSV.remove(sv);
                System.out.print("Đã xóa sinh viên này!!!");
            }

        }
        this.updateTK();
    }
    public void SuaSV() {
        System.out.print("Hãy nhập tên sinh viên muốn sửa: ");
        String tenCanSua = sc.nextLine();

        boolean found = false;

        for (SinhVien sv : danhSachSV) {
            if (sv.getTen().equalsIgnoreCase(tenCanSua)) {

                System.out.println("Nhập thông tin mới:");
                sv.NhapTT();

                found = true;
                System.out.println("Đã sửa thành công!!");

                break;
            }
        }

        if (!found) {
            System.out.println("Không tìm thấy sinh viên!");
            return;
        }
        this.updateTK();


    }

    public void muonSach(String tenTK) {
        DonMuonSach dms = new DonMuonSach();
        dms.setNguoiMuon(tenTK);
        dms.taoDon();
        dms.xuatDon();
        dms.saveToFile(fileDonMuon, true);
        dms.getSachMuon();
    }

}
