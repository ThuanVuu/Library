import java.util.Scanner;

public class NguoiDung {
    private String Ten, Email, DiaChi, SDT;
    private int MaSo;
    Scanner sc = new Scanner(System.in);

    public int getMaSo() {
        return MaSo;
    }

    public void setMaSo(int maSo) {
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
        this.setTen(sc.nextLine());
        System.out.println("Hay nhap Ma So:");
        this.setMaSo(Integer.parseInt(sc.nextLine()));
        System.out.println("Hay nhap email: ");
        this.setEmail(sc.nextLine());
        System.out.println("Hay nhap So Dien Thoai: ");
        this.setSDT(sc.nextLine());
        System.out.println("Hay nhap dia chi:");
        this.setDiaChi(sc.nextLine());
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
