import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class SinhVien extends NguoiDung{

    Scanner sc = new Scanner(System.in);
    private String mssv;
    private int theTV;
    private boolean phatTraSachMuon = false;
    private LocalDate date;

    public SinhVien() {

    }

    public void getDate() {
        System.out.println("Ngày tháng đã nhập: " + date);
    }

    public LocalDate setDate(){
        System.out.print("Nhập ngày tháng (dd/MM/yyyy): ");
        String input = sc.nextLine();

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        LocalDate transInput = LocalDate.parse(input, formatter);

        return this.date = transInput;
    }
}
