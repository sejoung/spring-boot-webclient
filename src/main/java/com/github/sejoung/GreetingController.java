package com.github.sejoung;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GreetingController {

	@GetMapping("/hello")
	public String hello() {
		System.out.println("asdasdsa");
		return "Hello World";
	}
}
