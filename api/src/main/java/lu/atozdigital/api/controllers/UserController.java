package lu.atozdigital.api.controllers;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import lu.atozdigital.api.entities.User;

@RestController
@CrossOrigin(origins = "*")
public class UserController {
	
	@GetMapping("/login")
	public String login(){
		return "authenticated successfully" ;
	}

}
