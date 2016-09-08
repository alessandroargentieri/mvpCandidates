package mawashi.alex.basicmvp.model;


public class CourseModel {
    private String coursename, description;

    public CourseModel(String coursename, String description){
        this.coursename = coursename;
        this.description = description;
    }

    public CourseModel(){

    }

    public void setCoursename(String coursename){
        this.coursename = coursename;
    }

    public String getCoursename(){
        return coursename;
    }

    public void setDescription(String description){
        this.description = description;
    }

    public String getDescription(){
        return description;
    }

}
