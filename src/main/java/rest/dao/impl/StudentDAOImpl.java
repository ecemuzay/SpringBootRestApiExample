package rest.dao.impl;

import org.springframework.stereotype.Component;
import rest.dao.StudentDAO;
import rest.model.Student;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by umutbuyukdurmus on 21.09.2016.
 */
@Component("studentDAO")
public class StudentDAOImpl implements StudentDAO{

    // Dummy database. Initialize with some dummy values.
    private static List<Student> students;
    {
        students = new ArrayList();
        students.add(new Student(101, "Umut", "Doe", "umut@gmail.com", "121-232-3435"));
        students.add(new Student(201, "james", "Smith", "james@gmail.com", "343-545-2345"));
        students.add(new Student(301, "ali", "Williams", "ali@gmail.com", "876-237-2987"));
        students.add(new Student(401, "ahmet", "Patel", "ahmet@gmail.com", "356-758-8736"));
    }

    /**
     * Returns list of Students from dummy database.
     *
     * @return list of Students
     */
    @Override
    public List list() {
        return students;
    }

    /**
     * Return Student object for given id from dummy database. If Student is
     * not found for id, returns null.
     *
     * @param id
     *            Student id
     * @return Student object for given id
     */
    @Override
    public Student get(Long id) {

        for (Student c : students) {
            if (c.getId().equals(id)) {
                return c;
            }
        }
        return null;
    }

    /**
     * Create new Student in dummy database. Updates the id and insert new
     * Student in list.
     *
     * @param student
     *            Student object
     * @return Student object with updated id
     */
    @Override
    public Student create(Student student) {
        student.setId(System.currentTimeMillis());
        students.add(student);
        return student;
    }

    /**
     * Delete the Student object from dummy database. If Student not found for
     * given id, returns null.
     *
     * @param id
     *            the Student id
     * @return id of deleted Student object
     */
    @Override
    public Long delete(Long id) {

        for (Student c : students) {
            if (c.getId().equals(id)) {
                students.remove(c);
                return id;
            }
        }

        return null;
    }

    /**
     * Update the Student object for given id in dummy database. If Student
     * not exists, returns null
     *
     * @param id
     * @param student
     * @return Student object with id
     */

    @Override
    public Student update(Long id, Student student) {

        for (Student c : students) {
            if (c.getId().equals(id)) {
                student.setId(c.getId());
                students.remove(c);
                students.add(student);
                return student;
            }
        }

        return null;
    }


}
