package edu.ap.spring.controllers;

import javax.websocket.server.PathParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import edu.ap.spring.model.InhaalExamen;
import edu.ap.spring.redis.RedisService;

@Controller
public class InhaalexamensController {

	private RedisService service;
	
	@Autowired
	public void setService(RedisService service) {
		this.service = service;
	}
	
	@RequestMapping("/list?student={student}")
	public String getStudent(@PathParam("student") String student, Model model) {
		model.addAttribute("inhaalExamens", service.getKey(student + "*"));
		
		return "list";
	}

   @PostMapping("/new")
   public String setInhaalexamen(@RequestParam("student") String student, 
		   				 @RequestParam("exam") String exam,
		   				 @RequestParam("reason") String reason,
		   				 Model model) {

	  InhaalExamen inhaalExamen = new InhaalExamen(student, exam, reason);
	  
      model.addAttribute("student", inhaalExamen.getStudent() );
      model.addAttribute("exam", inhaalExamen.getExam());
      model.addAttribute("reason", inhaalExamen.getReason());
      model.addAttribute("date", inhaalExamen.getDate());
      
      String result = model.toString();
      
      service.setKey(student + exam + reason, result);
      
      return result;
   }
}
