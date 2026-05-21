package com.example.demo.team16.Start;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
@Controller
public class Team16TestController {
		@GetMapping("/test")
		public String index() {
			return "team16/Start/Team16Test";
		}
		
}
