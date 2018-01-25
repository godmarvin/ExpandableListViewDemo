package jay.com.expandablelistviewdemo;

/**
 * Created by Jay on 2015/9/25 0025.
 */
public class Item {

    private int iId;
    private String iName;
    private boolean checked;


    public Item() {
    }


    public int getiId() {
        return iId;
    }

    public String getiName() {
        return iName;
    }

    public void setiId(int iId) {
        this.iId = iId;
    }

    public void setiName(String iName) {
        this.iName = iName;
    }

    public Item(int iId, String iName, boolean checked) {
        this.iId = iId;
        this.iName = iName;
        this.checked = checked;
    }

    public boolean isChecked() {
        return checked;
    }

    public void setChecked(boolean checked) {
        this.checked = checked;
    }
}
