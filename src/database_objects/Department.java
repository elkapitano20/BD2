package database_objects;

/**
 * Created by Pelmen on 22.01.2017.
 */
public class Department {

    private int departmentId;//PK
    private int deliverId;//FK
    private int listId;//FK
    private int workerId;//FK
    private int id;//FK dostawa do odzialu

    private String localization;
    private String name;
    private String adress;
    private int workersCount;//liczba pracownikow

    public void setDepartmentId(int departmentId) {
        this.departmentId = departmentId;
    }

    public void setDeliverId(int deliverId) {
        this.deliverId = deliverId;
    }

    public void setListId(int listId) {
        this.listId = listId;
    }

    public void setWorkerId(int workerId) {
        this.workerId = workerId;
    }

    public void setId(int id){
        this.id = id;
    }

    public void setLocalization(String localization) {
        this.localization = localization;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAdress(String adress) {
        this.adress = adress;
    }

    public void setWorkersCount(int workersCount) {
        this.workersCount = workersCount;
    }


    public int getDepartmentId() {
        return this.departmentId;
    }

    public int getDeliverId() {
        return this.deliverId;
    }

    public int getListId() {
        return this.listId;
    }

    public int getWorkerId() {
        return this.workerId;
    }

    public int getId(){
        return this.id;
    }

    public String getLocalization() {
        return this.localization;
    }

    public String getName() {
        return this.name;
    }

    public String getAdress() {
        return this.adress;
    }

    public int getWorkersCount() {
        return this.workersCount;
    }

}
