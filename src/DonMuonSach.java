import java.io.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.Scanner;

public class DonMuonSach {
    Scanner sc = new Scanner(System.in);

    App app = new App();
    private String ngayMuon;
    private int soNgay;
    private String sachMuon;
    private String nguoiMuon;
    private boolean tinhTrang;

    public DonMuonSach() {

    }

    public DonMuonSach(String ngayMuon, int soNgay, String sachMuon, String nguoiMuon, boolean tinhTrang) {
        this.ngayMuon = ngayMuon;
        this.soNgay = soNgay;
        this.sachMuon = sachMuon;
        this.nguoiMuon = nguoiMuon;
        this.tinhTrang = tinhTrang;
    }

    public void taoDon() {
        this.setNgayMuon();
        this.soNgay = 20;
        this.sachMuon = app.locSachTheoTen();
        this.tinhTrang = true;
    }

    public void xuatDon() {
        System.out.println("Ngày mượn sách: " + ngayMuon);
        System.out.println("Số ngày được cho phép: " + soNgay);
        System.out.println("Tên sách mượn: " + sachMuon);
        System.out.println("Tài khoản mượn: " + nguoiMuon);
    }

    public String toString() {
        return ngayMuon + " - " + soNgay + " - " + sachMuon + " - " + nguoiMuon + " - " + tinhTrang;
    }

    public String setDate(){
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        LocalDate transInput = null;

        while (true) {
            try {
                System.out.print("Nhập ngày tháng (dd/MM/yyyy): ");
                String input = sc.nextLine();
                transInput = LocalDate.parse(input, formatter);
                break;
            } catch (DateTimeParseException e) {
                System.out.println("Lỗi: ngày hoặc tháng không hợp lệ. Vui lòng nhập lại!!");
            }
        }

        return transInput.format(formatter);
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
                    String ngayMuon = arr[0].trim();
                    String soNgay = arr[1].trim();
                    String tenSach = arr[2].trim();
                    String nguoiMuon = arr[3].trim();
                    String tinhTrang = arr[4].trim();

                    DonMuonSach dms = new DonMuonSach(ngayMuon, Integer.parseInt(soNgay)
                            , tenSach, nguoiMuon, Boolean.parseBoolean(tinhTrang));
                    App.donMuonSach.add(dms);
                } catch (Exception e) {
                    System.out.println("Xảy ra lỗi!!");
                }
            }
        } catch (Exception e) {
            System.out.println("Lỗi không thể đọc file!!");
        }
    }

    public String getNgayMuon() {
        return ngayMuon;
    }

    public void setNgayMuon() {
        this.ngayMuon = this.setDate();
    }

    public int getSoNgay() {
        return soNgay;
    }

    public void setNgayTra(int soNgay) {
        this.soNgay = soNgay;
    }

    public String getSachMuon() {
        return sachMuon;
    }

    public void setSachMuon(String sachMuon) {
        this.sachMuon = sachMuon;
    }

    public String getNguoiMuon() {
        return nguoiMuon;
    }

    public void setNguoiMuon(String nguoiMuon) {
        this.nguoiMuon = nguoiMuon;
    }

    public boolean isTinhTrang() {
        return tinhTrang;
    }

    public void setTinhTrang(boolean tinhTrang) {
        this.tinhTrang = tinhTrang;
    }
}
