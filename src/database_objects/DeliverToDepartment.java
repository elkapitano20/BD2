package database_objects;

/**
 * Created by Pelmen on 22.01.2017.
 */
public class DeliverToDepartment {

    private int deliverToDepartmentId;//PK
    private int deliverId;//FK id dostawy
    private int departmentId;//FK id odzialu
    private int produktId;//FK id produktu

    public void setDeliverToDepartmentId(int deliverToDepartmentId) {
        this.deliverToDepartmentId = deliverToDepartmentId;
    }

    public void setDeliverId(int deliverId) {
        this.deliverId = deliverId;
    }

    public void setDepartmentId(int departmentId) {
        this.departmentId = departmentId;
    }

    public void setProduktId(int produktId) {
        this.produktId = produktId;
    }

    public int getDeliverToDepartmentId() {
        return this.deliverToDepartmentId;
    }

    public int getDeliverId() {
        return this.deliverId;
    }

    public int getDepartmentId() {
        return this.departmentId;
    }

    public int getProduktId() {
        return this.produktId;
    }

}
