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
    public static List<NguoiDung> danhSachND = new ArrayList<>();

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
                                case 2:
                                case 3:
                                case 4:
                                case 5:
                                case 6:
                                case 7:
                                default:
                                    System.out.println("Vui lòng nhập từ 0 - 7!!");
                                    break;
                            }
                        }
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
                                    menu = false;
                                    break;
                                case 1:
                                case 2:
                                case 3:
                                case 4:
                                case 5:
                                case 6:
                                case 7:
                                case 8:
                                default:
                                    System.out.println("Vui lòng nhập từ 0 - 8!!");
                                    break;
                            }
                        }
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
                                    menu = false;
                                    break;
                                case 1:
                                case 2:
                                case 3:
                                case 4:
                                case 5:
                                case 6:
                                case 7:
                                case 8:
                                case 9:
                                case 10:
                                default:
                                    System.out.println("Vui lòng nhập từ 0 - 10!!");
                                    break;
                            }
                        }
                }
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
    public void TimMK() {
        System.out.print("Nhập Tài Khoản Cần Tìm MK: ");
        String tenTkCanTim = sc.nextLine();

        System.out.print("Bạn muốn tìm bằng Email hay SDT (1-Email, 2-SDT): ");
        int chon = Integer.parseInt(sc.nextLine());

        boolean found = false;

        switch (chon) {
            case 1:
                System.out.print("Nhập Email: ");
                String email = sc.nextLine();

                for (NguoiDung nd : danhSachND) {
                    if (nd.getEmail().equalsIgnoreCase(email))
                    {
                        for(TaiKhoan tk : danhSachTK){
                           if(tk.getTaiKhoan().equalsIgnoreCase(tenTkCanTim))
                           {
                               System.out.println("Mật khẩu là: " + tk.getMatKhau());
                               found = true;
                               break;
                           }
                        }
                    }
                    break;
                }

                if (!found) {
                    System.out.println("Không tìm thấy tài khoản với email này!");
                }
                break;

            case 2:
                System.out.print("Nhập SĐT: ");
                String sdt = sc.nextLine();

                for (NguoiDung nd : danhSachND) {
                    if (nd.getSDT().equals(sdt)){
                        for(TaiKhoan tk: danhSachTK)
                        {
                            if(tk.getTaiKhoan().equalsIgnoreCase(tenTkCanTim)){
                                System.out.println("Mật khẩu là: " + tk.getMatKhau());
                                found = true;
                                break;
                            }
                        }
                    }
                }

                if (!found) {
                    System.out.println("Không tìm thấy tài khoản với SĐT này!");
                }
                break;

            default:
                System.out.println("Lựa chọn không hợp lệ!");
        }
    }



}
