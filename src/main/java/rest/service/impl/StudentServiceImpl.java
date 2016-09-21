package rest.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import rest.dao.StudentDAO;
import rest.model.Student;
import rest.service.StudentService;

import java.util.List;

/**
 * Created by umutbuyukdurmus on 21.09.2016.
 */
@Component("studentService")
public class StudentServiceImpl implements StudentService {

    @Autowired
    private StudentDAO studentDAO;

    @Override
    public Student update(Long id, Student student) {
        return studentDAO.update(id,student);
    }

    @Override
    public List list() {
        return studentDAO.list();
    }

    @Override
    public Student get(Long id) {
        return studentDAO.get(id);
    }

    @Override
    public Student create(Student student) {
        return studentDAO.create(student);
    }

    @Override
    public Long delete(Long id) {
        return studentDAO.delete(id);
    }
}
