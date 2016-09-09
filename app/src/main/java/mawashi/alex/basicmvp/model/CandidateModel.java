package mawashi.alex.basicmvp.model;


public class CandidateModel {
    private String email, name, surname, course;

    public CandidateModel(String email, String name, String surname, String course){
        this.email = email;
        this.name = name;
        this.surname = surname;
        this.course = course;
    }

    public CandidateModel(){

    }

    public void setEmail(String email){
        this.email = email;
    }

    public String getEmail(){
        return email;
    }

    public void setName(String name){
        this.name = name;
    }

    public String getName(){
        return name;
    }

    public void setSurname(String surname){
        this.surname = surname;
    }

    public String getSurname(){
        return surname;
    }

    public void setCourse(String course){
        this.course = course;
    }

    public String getCourse(){
        return course;
    }

}
