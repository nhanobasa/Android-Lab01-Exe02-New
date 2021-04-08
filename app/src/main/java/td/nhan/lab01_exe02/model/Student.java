package td.nhan.lab01_exe02.model;

public class Student {
    int resImg;
    String id;
    String name;
    String gender;
    String dob;

    public Student(int resImg, String id, String name, String gender, String dob) {
        this.resImg = resImg;
        this.id = id;
        this.name = name;
        this.gender = gender;
        this.dob = dob;
    }

    public int getResImg() {
        return resImg;
    }

    public void setResImg(int resImg) {
        this.resImg = resImg;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getDob() {
        return dob;
    }

    public void setDob(String dob) {
        this.dob = dob;
    }

    @Override
    public String toString() {
        return "Student{" +
                "resImg=" + resImg +
                ", id=" + id +
                ", name='" + name + '\'' +
                ", gender='" + gender + '\'' +
                ", dob='" + dob + '\'' +
                '}';
    }
}
