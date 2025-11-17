import java.util.Scanner;

public class NguoiDung {
    private String MaSo, Ten, Email, DiaChi, SDT;
    Scanner sc = new Scanner(System.in);

    public String getMaSo() {
        return MaSo;
    }

    public void setMaSo(String maSo) {
        MaSo = maSo;
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
    public void NhapTT()
    {
        System.out.print("Hay Nhap Ten:");
        String ten = sc.nextLine();


    }

}
