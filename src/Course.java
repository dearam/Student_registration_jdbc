import java.util.*;
public class Course {
    private int id;
    private String name;
    private int Mobile;
    private String courseName;
    public Course(int id,String name,int mobile,String c){
        this.id=id;
        this.name=name;
        this.Mobile=mobile;
        this.courseName=c;
    }

    public int getId(){
        return id;
    }
    public String getName(){
        return name;
    }
    public int getMobile(){
        return Mobile;
    }
    public String getCourse(){
        return courseName;
    }
}
