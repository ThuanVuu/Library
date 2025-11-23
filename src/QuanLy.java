public class QuanLy extends NguoiDung{
    private String phongBan;
    private int idQuanLy;
    private String vaiTro;
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

    public String getVaiTro() {
        return vaiTro;
    }

    public void setVaiTro(String vaiTro) {
        this.vaiTro = vaiTro;
    }
    @Override
    public void NhapTT()
    {
        super.NhapTT();
        System.out.print("Hãy Nhập Phòng Ban: ");
        this.setPhongBan(sc.nextLine());
        System.out.print("Hãy Nhập Mã Quản Lý: ");
        this.setIdQuanLy(Integer.parseInt(sc.nextLine()));
        System.out.print("Hãy Nhập Vai Trò: ");
        this.setVaiTro(sc.nextLine());
    }
    @Override
    public String toString()
    {
        return super.toString()+" - "+phongBan+" - "+idQuanLy+" - "+vaiTro;
    }

    @Override
    public void Xuat()
    {
        System.out.println(this.toString());
    }


}
