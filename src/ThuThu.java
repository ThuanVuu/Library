import java.time.LocalDate;

public class ThuThu extends NguoiDung{
    private String caTruc;
    private LocalDate ngayLamViec;
    private String phongBan;
    private int maSoTheTT;

    public ThuThu() {

    }

    public LocalDate getNgayLamViec() {
        return this.ngayLamViec;
    }

    public void setNgayLamViec() {
        this.ngayLamViec = super.setDate();
    }
}
