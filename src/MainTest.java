public class MainTest {

    public static void main(String[] args) {

        App app = new App();
        System.out.println(App.danhSachTK.get(1).getTaiKhoan());

        SinhVien sv = new SinhVien();
        sv.taoTK();
        System.out.println(sv.getTaiKhoan());
    }
}
