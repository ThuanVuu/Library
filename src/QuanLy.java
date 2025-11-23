public class QuanLy extends NguoiDung{
    private String phongBan;
    private int idQuanLy;
    private String ngayLamViec;

    public QuanLy() {

    }

    public String getNgayLamViec() {
        return this.ngayLamViec;
    }

    public void setNgayLamViec() {
        this.ngayLamViec = super.setDate();
    }

    public String getPhongBan() {
        return phongBan;
    }

    public void setPhongBan(String phongBan) {
        this.phongBan = phongBan;
    }

    public int getIdQuanLy()  {
        return idQuanLy;
    }

    public void setIdQuanLy(int idQuanLy)  {

        this.idQuanLy = idQuanLy;
    }

    @Override
    public void NhapTT()
    {
        super.NhapTT();
        System.out.print("Hãy Nhập Phòng Ban: ");
        this.setPhongBan(sc.nextLine());
        System.out.print("Hãy Nhập Mã Quản Lý: ");
        this.setIdQuanLy(Integer.parseInt(sc.nextLine()));
    }

    @Override
    public String toString() {
        return super.toString() + " - " + phongBan + " - " + idQuanLy;
    }

    @Override
    public void Xuat()
    {
        super.Xuat();
        System.out.println("Phòng Ban: "+phongBan);
        System.out.println("Mã Quản Lý: "+idQuanLy);
    }


}
