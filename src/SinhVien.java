import java.time.LocalDate;
import java.util.Scanner;

public class SinhVien extends NguoiDung{

    Scanner sc = new Scanner(System.in);
    private String mssv;
    private int theTV;
    private boolean phatTraSachMuon = false;
    private LocalDate ngayVaoTV;

    public SinhVien() {

    }

    public LocalDate getNgayVaoTV() {
        return this.ngayVaoTV;
    }

    public void setNgayVaoTV() {
        this.ngayVaoTV = super.setDate();
    }
}
