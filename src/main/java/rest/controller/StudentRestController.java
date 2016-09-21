package rest.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import rest.model.Student;
import rest.service.StudentService;

import java.util.List;

@RestController
public class StudentRestController {

	
	@Autowired
	private StudentService studentService;

	//@GetMapping("/students")
	@RequestMapping(value = "/students", method = RequestMethod.GET)
	public List getStudents() {
		return studentService.list();
	}

	//@GetMapping("/students/{id}")
	@RequestMapping(value = "/students/{id}", method = RequestMethod.GET)
	public ResponseEntity getStudent(@PathVariable("id") Long id) {

		Student student = studentService.get(id);
		if (student == null) {
			return new ResponseEntity("No Student found for ID " + id, HttpStatus.NOT_FOUND);
		}

		return new ResponseEntity(student, HttpStatus.OK);
	}

	//@PostMapping(value = "/students")
	@RequestMapping(value = "/students/create", method = RequestMethod.POST)
    @ResponseBody
	public ResponseEntity createStudent(@RequestBody Student student) {

		studentService.create(student);

		return new ResponseEntity(student, HttpStatus.OK);
	}

	//@DeleteMapping("/students/{id}")
	@RequestMapping(value = "/students/{id}", method = RequestMethod.DELETE)
	public ResponseEntity deleteStudent(@PathVariable Long id) {

		if (null == studentService.delete(id)) {
			return new ResponseEntity("No Student found for ID " + id, HttpStatus.NOT_FOUND);
		}

		return new ResponseEntity(id, HttpStatus.OK);

	}

	//@PutMapping("/students/{id}")
	@RequestMapping(value = "/students/{id}", method = RequestMethod.PUT)
	public ResponseEntity updateStudent(@PathVariable Long id, @RequestBody Student student) {

		student = studentService.update(id, student);

		if (null == student) {
			return new ResponseEntity("No Student found for ID " + id, HttpStatus.NOT_FOUND);
		}

		return new ResponseEntity(student, HttpStatus.OK);
	}

}