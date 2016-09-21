package client;

import org.springframework.web.client.RestTemplate;
import rest.model.Student;

import java.net.URI;
import java.util.LinkedHashMap;
import java.util.List;

public class SpringRestTestClient {
 
    public static final String REST_SERVICE_URI = "http://localhost:8080";
     
    /* GET */
    @SuppressWarnings("unchecked")
    private static void listAllStudents(){
        System.out.println("Testing listAllStudents API-----------");
         
        RestTemplate restTemplate = new RestTemplate();
        List<LinkedHashMap<String, Object>> studentsMap = restTemplate.getForObject(REST_SERVICE_URI+"/students", List.class);
         
        if(studentsMap!=null){
            for(LinkedHashMap<String, Object> map : studentsMap){
                System.out.println("Student : id="+map.get("id")+", Name="+map.get("firstName")+", Lastname="+map.get("lastName")+", Email="+map.get("email")+", Mobile="+map.get("mobile"));;
            }
        }else{
            System.out.println("No student exist----------");
        }
    }
     
    /* GET */
    private static void getStudent(){
        System.out.println("Testing getStudent API----------");
        RestTemplate restTemplate = new RestTemplate();
        Student student = restTemplate.getForObject(REST_SERVICE_URI+"/students/101", Student.class);
        System.out.println(student);
    }
     
    /* POST */
    private static void createStudents() {
        System.out.println("Testing create Student API----------");
        RestTemplate restTemplate = new RestTemplate();
        Student student = new Student(501,"Tuğba","Büyükdurmuş","aaa@gmail.com","123-132-2323");
        URI uri = restTemplate.postForLocation(REST_SERVICE_URI+"/students/create", student, Student.class);
        //System.out.println("Location : "+uri.toASCIIString());
    }
 
    /* PUT */
    private static void updateStudent() {
        System.out.println("Testing update Student API----------");
        RestTemplate restTemplate = new RestTemplate();
        Student student  = new Student(401,"Tuğba","Büyükdurmuş","aaabbbb@gmail.com","123-132-2323");
        restTemplate.put(REST_SERVICE_URI+"/students/401", student);
        System.out.println(student);
    }
 
    /* DELETE */
    private static void deleteStudent() {
        System.out.println("Testing delete Student API----------");
        RestTemplate restTemplate = new RestTemplate();
        restTemplate.delete(REST_SERVICE_URI+"/students/201");
    }
 
 

 
    public static void main(String args[]){
        listAllStudents();
        getStudent();
        createStudents();
        listAllStudents();
        updateStudent();
        listAllStudents();
        deleteStudent();
        listAllStudents();
    }
}