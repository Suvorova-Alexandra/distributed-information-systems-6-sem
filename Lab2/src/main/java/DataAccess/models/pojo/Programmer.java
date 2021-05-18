package DataAccess.models.pojo;



public class Programmer {
    private String FIO;
    private int experience;
    private String position;
    private String coreTechnology;
    private float salary;


    public Programmer(String FIO, int experience, String position, String coreTechnology, float salary) {
        this.FIO = FIO;
        this.experience = experience;
        this.position = position;
        this.coreTechnology = coreTechnology;
        this.salary = salary;
    }

    public String getFIO() {
        return FIO;
    }

    public int getExperience() {
        return experience;
    }

    public String getPosition() {
        return position;
    }

    public String getCoreTechnology() {
        return coreTechnology;
    }

    public float getSalary() {
        return salary;
    }


}
