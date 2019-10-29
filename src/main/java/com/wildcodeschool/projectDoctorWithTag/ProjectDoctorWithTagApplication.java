package com.wildcodeschool.projectDoctorWithTag;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.server.ResponseStatusException;
import org.springframework.stereotype.Controller;

@Controller
@SpringBootApplication
public class ProjectDoctorWithTagApplication {
	
	String[] tab = {"William Hartnell",
			"Jon Pertwee",
			"Tom Baker",
			"Peter Davison",
			"Colin Baker",
			"Sylvester McCoy",
			"Paul McGann",
			"John Hurt",
			"Christopher Eccleston",
			"David Tennant",
			"Matt Smith",
			"Peter Capaldi",
			"Jodie Whittaker"};
	public static void main(String[] args) {
		SpringApplication.run(ProjectDoctorWithTagApplication.class, args);
	}

	@RequestMapping("/doctor")
    @ResponseBody
    public String index() {
		int i=0;
		String html = "<ul>";
		while(i<tab.length) {
			i++;
			html += 
					 "<a href=\"./"+ i+"\"><li> Acteur n°"+i+"</li></a>"
					;
		}
		return html + "</ul>";
 
    }
	
	@RequestMapping("/doctor/{id}")
    @ResponseBody
    public String tagDoctor(@PathVariable int id) {
		if(id <= 8) {
			throw new ResponseStatusException(HttpStatus.SEE_OTHER, "Error 303 NOT HERE");
		}
		if(id > 13) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Impossible d	e récupérer l'incarnation "+id);
		}
		return "L'acteur est " + tab[id];
	}
}
