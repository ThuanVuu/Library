import java.util.Scanner;

public class SinhVien extends NguoiDung{

    Scanner sc = new Scanner(System.in);
    private String mssv;
    private int theTV;
    private boolean phatTraSachMuon = false;
    private String ngayVaoTV;

    public SinhVien() {

    }

    public boolean isPhatTraSachMuon() {
        return phatTraSachMuon;
    }

    public void setPhatTraSachMuon(boolean phatTraSachMuon) {
        this.phatTraSachMuon = phatTraSachMuon;
    }

    public String getMssv() {
        return mssv;
    }

    public void setmssv(String mssv) {
        this.mssv = mssv;
    }

    public int getTheTV() {
        return theTV;
    }

    public void settheTV(int theTV) {

        this.theTV = theTV;
    }

    public String getNgayVaoTV() {
        return this.ngayVaoTV;
    }

    public void setNgayVaoTV() {
        this.ngayVaoTV = super.setDate();
    }

    @Override
    public void NhapTT()
    {
        super.NhapTT();
        System.out.println("Hãy Nhập Mã Số Sinh Viên: ");
        this.setmssv(sc.nextLine());

        System.out.println("Hãy Nhập Mã Thẻ Thư Viện: ");
        this.settheTV(Integer.parseInt(sc.nextLine()));
    }

    @Override
    public String toString()
    {
        return super.toString()+"\n"+"MSSV: "+mssv+"\n"+"Mã Số Thẻ Thư Viện: "+theTV ;
    }

    @Override
    public void Xuat()
    {
        System.out.println(this.toString());
    }

}
