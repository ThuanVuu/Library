import java.io.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.Scanner;

public class Sach {

    Scanner sc = new Scanner(System.in);
    private String tacGia;
    private String tenSach;
    private String ngayXB;
    private int maSach;
    private String ngayMuon;
    private String nguoiMuon;
    private String ngayTra;

    public Sach() {

    }

    public Sach(String tacGia, String tenSach, String ngayXB, int maSach, String ngayMuon, String nguoiMuon, String ngayTra) {
        this.tacGia = tacGia;
        this.tenSach = tenSach;
        this.ngayXB = ngayXB;
        this.maSach = maSach;
        this.ngayMuon = ngayMuon;
        this.nguoiMuon = nguoiMuon;
        this.ngayTra = ngayTra;
    }

    public void nhapTT() {
        System.out.print("Nhập tên sách: ");
        this.setTenSach(sc.nextLine());
        System.out.print("Nhập tên tác giả: ");
        this.setTacGia(sc.nextLine());
        this.setNgayXB();
        System.out.print("Nhập mã sách (0 - 100): ");
        this.setMaSach(Integer.parseInt(sc.nextLine()));
        this.ngayMuon = "00/00/0000";
        this.ngayTra = "00/00/0000";
        this.nguoiMuon = null;
    }

    public void xuatTT() {
        System.out.println("Tên Sách: " + tenSach);
        System.out.println("Tác Giả: " + tacGia);
        System.out.println("Ngày Xuất Bản: " + ngayXB);
        System.out.println("Mã sách: " + maSach);
        System.out.println("Ngày mượn sách: " + ngayMuon);
        System.out.println("Ngày trả sách: " + ngayTra);
        System.out.println("Người mượn: " + nguoiMuon);
    }

    public String toString() {
        return tenSach + " - " + tacGia + " - " + ngayXB + " - " + maSach + " - " + ngayMuon + " - " + ngayTra + " - "
                + nguoiMuon;
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
                    String tenSach = arr[0].trim();
                    String tacGia = arr[1].trim();
                    String NXB = arr[2].trim();
                    String maSach = arr[3].trim();
                    String ngayMuon = arr[4].trim();
                    String ngayTra = arr[5].trim();
                    String nguoiMuon = arr[6].trim();

                    Sach sach = new Sach(tacGia, tenSach, NXB, Integer.parseInt(maSach), ngayMuon, nguoiMuon, ngayTra);
                    App.khoSach.add(sach);
                } catch (Exception e) {
                    System.out.println("Xảy ra lỗi!!");
                }
            }
            br.close();
            fr.close();
        } catch (Exception e) {
            System.out.println("Lỗi không thể đọc file!!");
        }
    }

    public String getTacGia() {
        return tacGia;
    }

    public void setTacGia(String tacGia) {
        this.tacGia = tacGia;
    }

    public String getTenSach() {
        return tenSach;
    }

    public void setTenSach(String tenSach) {
        this.tenSach = tenSach;
    }

    public String getNgayXB() {
        return ngayXB;
    }

    public void setNgayXB() {
        this.ngayXB = this.setDate();
    }

    public int getMaSach() {
        return maSach;
    }

    public void setMaSach(int maSach) {
        this.maSach = maSach;
    }

    public String getNgayMuon() {
        return ngayMuon;
    }

    public void setNgayMuon(String ngayMuon) {
        this.ngayMuon = ngayMuon;
    }

    public String getNguoiMuon() {
        return nguoiMuon;
    }

    public void setNguoiMuon(String nguoiMuon) {
        this.nguoiMuon = nguoiMuon;
    }

    public String getNgayTra() {
        return ngayTra;
    }

    public void setNgayTra(String ngayTra) {
        this.ngayTra = ngayTra;
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


}
