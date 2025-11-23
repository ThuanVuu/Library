import java.time.LocalDate;

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

    public void setIdQuanLy(int idQuanLy) throws Exception {
        if(idQuanLy <0)
        {
            throw new Exception("Không thể bé hơn 0");
        }
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
        System.out.println("Hãy Nhập Phòng Ban: ");
        this.setPhongBan(sc.nextLine());
        boolean KT = false;
        while(!KT)
        {
            try{
                System.out.println("Hãy Nhập Mã Quản Lý: ");
                this.setIdQuanLy(Integer.parseInt(sc.nextLine()));
                KT = true;
            }
            catch(Exception e){
                System.out.println("Lỗi:" + e.getMessage());
                System.out.println("Hãy Nhập Lại!!");
            }
        }

        System.out.println("Hãy Nhập Vai Trò: ");
        this.setVaiTro(sc.nextLine());
    }
    @Override
    public String toString()
    {
        return super.toString()+"\n"+"Phòng Ban: "+phongBan+"\n"+"Mã Quản Lý: "+idQuanLy+"\n"+"Vai Trò: "+vaiTro;
    }

    @Override
    public void Xuat()
    {
        System.out.println(this.toString());
    }


}
