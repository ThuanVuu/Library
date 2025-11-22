import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class NguoiDung {
    private String Ten, Email, DiaChi, SDT;
    private int MaSo;
    Scanner sc = new Scanner(System.in);

    public int getMaSo() {
        return MaSo;
    }

    public void setMaSo(int MaSo) throws Exception {
       if(MaSo<0)
       {
           throw new Exception("Mã Số Không Bé Hơn 0");
       }
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
        boolean KT = false;
        System.out.print("Hãy Nhập Tên: ");
        this.setTen(sc.nextLine());

        while(!KT)
        {
            try{
                System.out.println("Hãy Nhâp Mã Số: ");
                this.setMaSo(Integer.parseInt(sc.nextLine()));
                KT = true;
            }
            catch(Exception e){
                System.out.println("Lỗi"+e.getMessage());
                System.out.println("Hãy Nhập Lại!!");
            }
        }

        System.out.println("Hãy Nhập Email: ");
        this.setEmail(sc.nextLine());
        System.out.println("Hãy Nhập Số Điện Thoại: ");
        this.setSDT(sc.nextLine());
        System.out.println("Hãy Nhập Địa Chỉ: ");
        this.setDiaChi(sc.nextLine());
    }

    public String toString()
    {
        return"Tên: "+Ten+"\n"+"Mã Số: "+MaSo+"\n"+"Email: "+Email+"\n"+"Số Điện Thoại: "+SDT+"\n"+"Địa Chỉ: "+DiaChi;
    }

    public void Xuat()
    {
        System.out.println(this.toString());
    }

    public LocalDate setDate(){
        System.out.print("Nhập ngày tháng (dd/MM/yyyy): ");
        String input = sc.nextLine();

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        LocalDate transInput = LocalDate.parse(input, formatter);
        System.out.println("Ngày tháng đã nhập: " + transInput);

        return transInput;
    }
}
