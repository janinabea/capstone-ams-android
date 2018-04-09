package hernandez.com.iics.materializedattendance;

/**
 * Created by Biancake on 4/9/2018.
 */

public class Faculty {
    private int facultyId;
    private String facultyName;
    private String facultyDept;

    public Faculty(int facultyId, String facultyName, String facultyDept) {
        this.facultyId = facultyId;
        this.facultyName = facultyName;
        this.facultyDept = facultyDept;
    }

    public int getFacultyId() {
        return facultyId;
    }

    public void setFacultyId(int facultyId) {
        this.facultyId = facultyId;
    }

    public String getFacultyName() {
        return facultyName;
    }

    public void setFacultyName(String facultyName) {
        this.facultyName = facultyName;
    }

    public String getFacultyDept() {
        return facultyDept;
    }

    public void setFacultyDept(String facultyDept) {
        this.facultyDept = facultyDept;
    }
}
