package src;
import java.util.ArrayList;

public class HospitalReports {
    private static HospitalReports hospitalReports;
    private ArrayList<HospitalReport> hreportList;

    private HospitalReports() {
        hreportList = DataLoader.loadHReports();
    }

    public static HospitalReports getInstance() {
        if (hospitalReports == null) {
            hospitalReports = new HospitalReports();
        }
        return hospitalReports;
    }

    public boolean haveHReport(String hreportID) {
        for (HospitalReport hreport : hreportList) {
            if (hreport.getID().equals(hreportID)) {
                return true;
            }
        }
        return false;
    }

    public HospitalReport getHReport(String id) {
        for (HospitalReport hreport : hreportList) {
            if (hreport.getID().equals(id) {
                return hreport;
            }
        }
        return null;
    }

    public ArrayList<HospitalReport> getHReports() {
        return hreportList;
    }

    public boolean addHReport(String id,
                              String diagnosis,
                              String cause,
                              Person doctor,
                              Person nurse,
                              String dateAdmitted,
                              int numDays) {
        if (haveHReport(id)) {
            return false;
        }
        hreportList.add(new HospitalReport(id, diagnosis, cause, doctor, nurse, dateAdmitted, numDays));
        return true;
    }

    public void saveHospitalReports() {
        DataWriter.saveHospitalReports();
    }
    
}
