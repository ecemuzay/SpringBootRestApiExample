package rest.service;

import org.springframework.stereotype.Component;
import rest.model.Student;

import java.util.List;

/**
 * Created by umutbuyukdurmus on 21.09.2016.
 */

public interface StudentService {

    Student update(Long id, Student student);

    List list();

    Student get(Long id);

    Student create(Student student);

    Long delete(Long id);
}
