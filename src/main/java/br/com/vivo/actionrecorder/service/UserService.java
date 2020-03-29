package br.com.vivo.actionrecorder.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.vivo.actionrecorder.converter.UserConverter;
import br.com.vivo.actionrecorder.dto.request.UserDTO;
import br.com.vivo.actionrecorder.dto.response.CreateDTOResponse;
import br.com.vivo.actionrecorder.entity.User;
import br.com.vivo.actionrecorder.repository.UserRepository;

@Service
public class UserService {

	@Autowired
	UserRepository repository;
	
	@Autowired
	UserConverter converter;
	
	public CreateDTOResponse create(UserDTO userDTO) {
		return new CreateDTOResponse(repository.save(converter.toEntity(userDTO)).getUserId());
	}
	
	public User find(Long userId){
		Optional<User> user = repository.findById(userId);
		if(!user.isPresent()) {
			throw new RuntimeException("User not found");
		}
		return user.get();
	}
}
