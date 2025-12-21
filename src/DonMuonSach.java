import java.io.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.Scanner;

public class DonMuonSach {
    Scanner sc = new Scanner(System.in);
    App app = new App();

    private String ngayMuon;
    private String ngayTra;
    private String sachMuon;
    private String nguoiMuon;
    private boolean tinhTrang;

    public DonMuonSach() {

    }

    public DonMuonSach(String ngayMuon, String soNgay, String sachMuon, String nguoiMuon, boolean tinhTrang) {
        this.ngayMuon = ngayMuon;
        this.ngayTra = soNgay;
        this.sachMuon = sachMuon;
        this.nguoiMuon = nguoiMuon;
        this.tinhTrang = tinhTrang;
    }

    public void taoDon() {
        this.setNgayMuon();
        this.setNgayTra(20);
        app.inSach();
        this.sachMuon = app.locSachTheoTen();
        if (this.sachMuon.equalsIgnoreCase("Không tìm thấy sách trùng tên bạn muốn")) {
            this.tinhTrang = false;
        } else {
            app.setTTMuonSach(ngayMuon, ngayTra, sachMuon);
            this.tinhTrang = true;
        }
    }

    public void xuatDon() {
        System.out.println("Ngày mượn sách: " + ngayMuon);
        System.out.println("Ngày phải trả: " + ngayTra);
        System.out.println("Tên sách mượn: " + sachMuon);
        System.out.println("Tài khoản mượn: " + nguoiMuon);
    }

    public String toString() {
        return ngayMuon + " - " + ngayTra + " - " + sachMuon + " - " + nguoiMuon + " - " + tinhTrang;
    }

    public String setDate(){
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        LocalDate transInput = null;

        while (true) {
            try {
                System.out.print("Nhập ngày hôm nay (dd/mm/YYYY): ");
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
                    String ngayTra = arr[1].trim();
                    String tenSach = arr[2].trim();
                    String nguoiMuon = arr[3].trim();
                    String tinhTrang = arr[4].trim();

                    DonMuonSach dms = new DonMuonSach(ngayMuon, ngayTra
                            , tenSach, nguoiMuon, Boolean.parseBoolean(tinhTrang));
                    App.donMuonSach.add(dms);
                } catch (Exception e) {
                    System.out.println("Xảy ra lỗi!!");
                }
            }
            fr.close();
            br.close();
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

    public String getNgayTra() {
        return ngayTra;
    }

    public void setNgayTra(int soNgay) {
        String input = this.ngayMuon;
        String[] parts = input.split("/");

        int day = Integer.parseInt(parts[0]) + soNgay;
        int month = Integer.parseInt(parts[1]);
        int year = Integer.parseInt(parts[2]);

        if ((year % 400 == 0 ) || (year % 4 == 0 && year % 100 != 0)) {
            if (day > 29 && month == 2) {
                day -= 29;
                month += 1;
            } else if (day > 31 && month % 2 != 0 && month <= 7) {
                day -= 31;
                month += 1;
            } else if (day > 30 && month % 2 == 0 && month <= 7) {
                day -= 30;
                month += 1;
            } else if (day > 31 && month % 2 == 0 && month < 12) {
                day -= 31;
                month += 1;
            } else if (day > 30 && month % 2 != 0 && month < 12) {
                day -= 30;
                month += 1;
            } else if (day > 31 && month == 12) {
                day -= 31;
                month = 1;
                year += 1;
            }
        } else {
            if (day > 28 && month == 2) {
                day -= 28;
                month += 1;
            } else if (day > 31 && month % 2 != 0 && month <= 7) {
                day -= 31;
                month += 1;
            } else if (day > 30 && month % 2 == 0 && month <= 7) {
                day -= 30;
                month += 1;
            } else if (day > 31 && month % 2 == 0 && month < 12) {
                day -= 31;
                month += 1;
            } else if (day > 30 && month % 2 != 0 && month < 12) {
                day -= 30;
                month += 1;
            } else if (day > 31 && month == 12) {
                day -= 31;
                month = 1;
                year += 1;
            }
        }

        this.ngayTra = day + "/" + month + "/" + year;
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
