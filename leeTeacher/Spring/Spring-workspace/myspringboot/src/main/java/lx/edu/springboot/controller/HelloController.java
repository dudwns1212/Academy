package lx.edu.springboot.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import lx.edu.springboot.dao.AddrBookDAO;
import lx.edu.springboot.vo.AddrBookVO;

@Controller
public class HelloController {

	@Autowired
	AddrBookDAO dao;
	
	@RequestMapping("/hello")
	public String hello(Model model) throws Exception {
		AddrBookVO vo = dao.getDB(27);
		model.addAttribute("vo", vo);
		return "hello";
	}	
}
