public class ThuThu extends NguoiDung{
    private String caTruc;
    private String ngayLamViec;
    private String phongBan;
    private int maSoTheTT;

    public ThuThu() {

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
