package br.com.vivo.actionrecorder.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import br.com.vivo.actionrecorder.dto.request.UserDTO;
import br.com.vivo.actionrecorder.dto.response.CreateDTOResponse;
import br.com.vivo.actionrecorder.dto.response.UserDTOResponse;
import br.com.vivo.actionrecorder.service.UserService;

@RestController
@RequestMapping("/record")
public class UserRestController {

	@Autowired
	UserService userService;
	
	@PostMapping("/user")
	@ResponseStatus(code = HttpStatus.CREATED, value = HttpStatus.CREATED)
	public CreateDTOResponse createUser(@RequestBody UserDTO user){
		return userService.create(user);
	}
	
	@GetMapping(path="/user/{userId}")
	@ResponseStatus(code = HttpStatus.OK, value = HttpStatus.OK)
	public UserDTOResponse getUser(@RequestParam(name = "userId") Long userId){
		return userService.find(userId);
	}
	
	@GetMapping(path="/user")
	@ResponseStatus(code = HttpStatus.OK, value = HttpStatus.OK)
	public UserDTOResponse getUserByDocumentNumber(@RequestParam(name = "documentNumber") Long documentNumber){
		return userService.findByDocumentNumber(documentNumber);
	}
	
	@DeleteMapping("/user/{userId}")
	@ResponseStatus(code = HttpStatus.NO_CONTENT, value = HttpStatus.NO_CONTENT)
	public void deleteUser(@PathVariable(name = "userId") Long userId){
		userService.delete(userId);
	}
	
}
