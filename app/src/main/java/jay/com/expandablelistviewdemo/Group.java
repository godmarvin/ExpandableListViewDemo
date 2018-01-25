package jay.com.expandablelistviewdemo;

/**
 * Created by Jay on 2015/9/25 0025.
 */
public class Group {
    private String gName;
    private boolean checked;
    public Group() {
    }

    public boolean isChecked() {
        return checked;
    }

    public void setChecked(boolean checked) {
        this.checked = checked;
    }

    public Group(String gName, boolean checked) {

        this.gName = gName;
        this.checked = checked;
    }


    public String getgName() {
        return gName;
    }

    public void setgName(String gName) {
        this.gName = gName;
    }
}
