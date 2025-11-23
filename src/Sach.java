import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.Scanner;

public class Sach {

    Scanner sc = new Scanner(System.in);
    private String tacGia;
    private String tenSach;
    private LocalDate ngayXB;
    private int maSach;

    public Sach() {

    }

    public void nhapTT() {
        System.out.print("Nhập tên sách: ");
        this.setTenSach(sc.nextLine());
        System.out.print("Nhập tên tác giả: ");
        this.setTacGia(sc.nextLine());
        this.setNgayXB();
        System.out.print("Nhập mã sách: ");
        this.setMaSach(Integer.parseInt(sc.nextLine()));
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

    public LocalDate getNgayXB() {
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

    public LocalDate setDate(){
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

        return transInput;
    }
}
