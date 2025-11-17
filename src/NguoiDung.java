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
         Ten = sc.nextLine();
        System.out.println("Hay nhap Ma So:");
        MaSo = sc.nextLine();
        System.out.println("Hay nhap email: ");
        Email = sc.nextLine();
        System.out.println("Hay nhap So Dien Thoai: ");
        SDT = sc.nextLine();
        System.out.println("Hay nhap dia chi:");
        DiaChi = sc.nextLine();
    }

    public String toString()
    {
        return"Ten: " +Ten + "Ma So: "+ MaSo + "Email: "+Email +"So Dien Thoai: "+ SDT +"Dia Chi: "+DiaChi;
    }

    public void Xuat()
    {
        System.out.println(this.toString());
    }


}
