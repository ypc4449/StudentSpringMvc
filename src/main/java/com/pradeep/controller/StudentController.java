package com.pradeep.controller;

import java.io.IOException;
import java.util.List;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.pradeep.model.Student;
import com.pradeep.service.StudentService;

@Controller
public class StudentController {
	@Autowired
	private StudentService studentService;

	@RequestMapping(value = "/")

	public ModelAndView printStudentList(ModelAndView model) throws IOException {

		model.addObject("studentList", studentService.getAllStudent());
		model.setViewName("home");
		return model;
	}

	@RequestMapping(value = "/newStudent", method = RequestMethod.GET)
	public ModelAndView newStudent(ModelAndView model) {
		Student student = new Student();
		model.addObject("student", student);
		model.setViewName("StudentForm");
		return model;
	}

	@RequestMapping(value = "/saveStudent", method = RequestMethod.POST)
	public ModelAndView saveStudent(@ModelAttribute Student student) {
		if (student.getStudentId() == 0) { 
			studentService.addStudent(student);
		} else {
			studentService.updateStudent(student);
		}
		return new ModelAndView("redirect:/");
	}

	@RequestMapping(value = "/deleteStudent", method = RequestMethod.GET)
	public ModelAndView deleteStudent (HttpServletRequest request)  {
		int studentId = Integer.parseInt(request.getParameter("studentid"));
		studentService.deleteStudent(studentId);
		return new ModelAndView("redirect:/");
	}

	@RequestMapping(value = "/editStudent", method = RequestMethod.GET)
	public ModelAndView editStudent(HttpServletRequest request) {
		int studentId = Integer.parseInt(request.getParameter("studentid"));
	Student student = studentService.getStudent(studentId);
		ModelAndView model = new ModelAndView("StudentForm");
		model.addObject("student", student);

		return model;
	}
	
	@RequestMapping(value = "/searchStudent", method = RequestMethod.GET)
	public ModelAndView searchStudent() {
     ModelAndView model=new ModelAndView("SearchForm");
     
		return model;
	}
	

	
	@RequestMapping(value = "/printStudentResult")
	public ModelAndView printStudentResults(ModelAndView model, String name) throws Throwable{

		model.addObject("studentResultList", studentService.getStudentByName(name));
		model.setViewName("result");
		return model;
	}

	

}
