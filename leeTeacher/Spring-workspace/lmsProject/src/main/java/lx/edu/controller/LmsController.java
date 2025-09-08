package lx.edu.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import jakarta.servlet.http.HttpServletRequest;
import lx.edu.dao.LmsDAO;
import lx.edu.vo.StudentInfo;

@Controller
public class LmsController {

	@Autowired
	LmsDAO dao;

	@GetMapping("/")
	public String home() {
		System.out.println("홈 페이지 호출됨!");
		return "home"; // 임시
	}

	@GetMapping("/student_list.do")
	public String stList(HttpServletRequest req) {
		List<StudentInfo> list = dao.getStudentList();
		req.setAttribute("data", list);
		return "lms";

	}

}
