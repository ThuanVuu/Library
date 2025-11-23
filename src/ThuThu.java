public class ThuThu extends NguoiDung{
    private String caTruc;
    private String ngayLamViec;
    private String phongBan;
    private int maSoTheTT;

    public ThuThu() {

    }

    public ThuThu(String Ten, int MaSo, String Email, String SDT, String DiaChi, String caTruc, String ngayLamViec, String phongBan, int maSoTheTT) {
        super(Ten, MaSo, Email, SDT, DiaChi);
        this.caTruc = caTruc;
        this.ngayLamViec = ngayLamViec;
        this.phongBan = phongBan;
        this.maSoTheTT = maSoTheTT;
    }

    public void setMaSoTheTT(int maSoTheTT)  {

        this.maSoTheTT= maSoTheTT;
    }

    public int getMaSoTheTT() {
        return this.maSoTheTT;
    }

    public String getNgayLamViec() {
        return this.ngayLamViec;
    }

    public void setNgayLamViec() {
        this.ngayLamViec = super.setDate();
    }

    public String getCaTruc() {
        return caTruc;
    }

    public void setCaTruc(String caTruc) {
        this.caTruc = caTruc;
    }

    public String getPhongBan() {
        return phongBan;
    }

    public void setPhongBan(String phongBan) {
        this.phongBan = phongBan;
    }

    @Override
    public void NhapTT()
    {
        super.NhapTT();
        System.out.print("Hãy Nhập Ca Trực: ");
        this.setCaTruc(sc.nextLine());
        System.out.print("Hãy Nhập Phòng Ban: ");
        this.setPhongBan(sc.nextLine());
        System.out.print("Hãy Nhập Mã Số Thẻ Thư Viện: ");
        this.setMaSoTheTT(Integer.parseInt(sc.nextLine()));
        System.out.print("Hãy Nhập Ngày Làm Việc: ");
        this.setNgayLamViec();
    }

    @Override
    public String toString() {
        return super.toString() + " - " + caTruc + " - " + ngayLamViec +" - " + phongBan + " - " + maSoTheTT;
    }
    @Override
    public void Xuat()
    {
        super.Xuat();
        System.out.println("Ca Trực: "+caTruc);
        System.out.println("Phòng Ban: "+phongBan);
        System.out.println("Mã Số Thẻ Thư Viện: "+maSoTheTT);
    }
}
