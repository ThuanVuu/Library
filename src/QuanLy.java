import java.time.LocalDate;

public class QuanLy extends NguoiDung{
    private String phongBan;
    private int idQuanLy;
    private String vaiTro;
    private LocalDate ngayLamViec;

    public QuanLy() {

    }

    public LocalDate getNgayLamViec() {
        return this.ngayLamViec;
    }

    public void setNgayLamViec() {
        this.ngayLamViec = super.setDate();
    }
}
