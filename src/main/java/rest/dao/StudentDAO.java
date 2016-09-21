package rest.dao;

import rest.model.Student;

import java.util.List;


public interface StudentDAO {

	Student update(Long id, Student student);

	List list();

	Student get(Long id);

    Student create(Student student);

    Long delete(Long id);


}