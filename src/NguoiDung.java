import java.io.File;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.Scanner;

public class NguoiDung extends TaiKhoan{
    private String Ten, Email, DiaChi, SDT;
    private int MaSo;
    Scanner sc = new Scanner(System.in);

    public int getMaSo() {
        return MaSo;
    }

    public void setMaSo(int MaSo)  {

        this.MaSo = MaSo;
    }

    public String getTen() {
        return Ten;
    }

    public void setTen(String ten) {
        Ten = ten;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String email) {
        Email = email;
    }

    public String getDiaChi() {
        return DiaChi;
    }

    public void setDiaChi(String diaChi) {
        DiaChi = diaChi;
    }

    public String getSDT() {
        return SDT;
    }

    public void setSDT(String SDT) {
        this.SDT = SDT;
    }
    public NguoiDung(){

    }

    public NguoiDung(String Ten, int MaSo, String Email, String SDT, String DiaChi) {
        this.Ten = Ten;
        this.MaSo = MaSo;
        this.Email = Email;
        this.SDT = SDT;
        this.DiaChi = DiaChi;
    }

    public void NhapTT()
    {
        System.out.print("Hãy Nhập Tên: ");
        this.setTen(sc.nextLine());
        System.out.print("Hãy Nhâp Mã Số: ");
        this.setMaSo(Integer.parseInt(sc.nextLine()));
        System.out.print("Hãy Nhập Email: ");
        this.setEmail(sc.nextLine());
        System.out.print("Hãy Nhập Số Điện Thoại: ");
        this.setSDT(sc.nextLine());
        System.out.print("Hãy Nhập Địa Chỉ: ");
        this.setDiaChi(sc.nextLine());
    }

    @Override
    public String toString() {
        return super.toString() + " - " + MaSo + " - " + Ten + " - " + Email + " - " + SDT + " - " + DiaChi;
    }

    public void Xuat()
    {
        System.out.println(this.toString());
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
