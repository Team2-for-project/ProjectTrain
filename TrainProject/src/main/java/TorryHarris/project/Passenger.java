package TorryHarris.project;

public class Passenger {
    private String pname;
    private int age;
    private String gender;

    public Passenger() {
    }

    public Passenger(String pname, int age, String gender) {
        this.pname = pname;
        this.age = age;
        this.gender = gender;
    }

    public String getPname() {
        return pname;
    }

    public void setPname(String pname) {
        this.pname = pname;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    @Override
    public String toString() {
        return "Passenger{" +
                "pname='" + pname + '\'' +
                ", age=" + age +
                ", gender='" + gender + '\'' +
                '}';
    }
}

