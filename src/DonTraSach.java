public class DonTraSach {

    private String ngayTra;
    private String ngayMuon;
    private String nguoiMuon;
    private String tenSach;
    private boolean tinhTrang;
    private boolean nopTre;

    public DonTraSach() {
    }

    public DonTraSach(String ngayTra, String ngayMuon, String nguoiMuon, String tenSach, boolean tinhTrang, boolean nopTre) {
        this.ngayTra = ngayTra;
        this.ngayMuon = ngayMuon;
        this.nguoiMuon = nguoiMuon;
        this.tenSach = tenSach;
        this.tinhTrang = tinhTrang;
        this.nopTre = nopTre;
    }

    public void locDonTheoTK(String tenTK) {
        for (DonMuonSach dms : App.donMuonSach) {
            if (dms.getNguoiMuon().equalsIgnoreCase(tenTK)) {
                System.out.print("Nhập ngày tháng hôm nay (dd/mm/YYYY): ");

            }
        }
    }

    public boolean kiemTraPhat() {
        String inputMuon = ngayMuon;
        String inputTra = ngayTra;

        String[] muonParts = inputMuon.split("/");
        String[] traParts = inputTra.split("/");

        int ngayMuon = Integer.parseInt(muonParts[0]);
        int thangMuon = Integer.parseInt(muonParts[1]);
        int namMuon = Integer.parseInt(muonParts[2]);
        int ngayTra = Integer.parseInt(traParts[0]);
        int thangTra = Integer.parseInt(traParts[1]);
        int namTra = Integer.parseInt(traParts[2]);

        return false;
    }

    public void taoDon() {

    }
}
