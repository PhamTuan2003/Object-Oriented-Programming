package vn.com.vds.model;

public class UserDAO {

    private int uniqueId;

    public boolean isDBConnected() {
        return false;
    }

    public int getUniqueId() {
        return this.uniqueId;
    }

    public void setUniqueId(int uniqueId) {
        this.uniqueId = uniqueId;
    }
}
