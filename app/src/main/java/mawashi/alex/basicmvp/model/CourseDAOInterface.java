package mawashi.alex.basicmvp.model;


import java.util.ArrayList;

public interface CourseDAOInterface {

    public void InsertCourse(CourseModel c);

    public ArrayList getCourses();
}
