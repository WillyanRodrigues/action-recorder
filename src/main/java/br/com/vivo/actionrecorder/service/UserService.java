package br.com.vivo.actionrecorder.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import br.com.vivo.actionrecorder.converter.UserConverter;
import br.com.vivo.actionrecorder.dto.request.UserDTO;
import br.com.vivo.actionrecorder.dto.response.CreateDTOResponse;
import br.com.vivo.actionrecorder.dto.response.UserDTOResponse;
import br.com.vivo.actionrecorder.entity.User;
import br.com.vivo.actionrecorder.exception.ResourceException;
import br.com.vivo.actionrecorder.repository.UserRepository;

@Service
public class UserService {

	@Autowired
	UserRepository repository;
	
	@Autowired
	LineService lineService;
	
	@Autowired
	UserConverter converter;
	
	public CreateDTOResponse create(UserDTO userDTO) {
		return new CreateDTOResponse(repository.save(converter.toEntity(userDTO)).getUserId());
	}
	
	public UserDTOResponse find(Long userId){
		Optional<User> user = repository.findById(userId);
		if(!user.isPresent()) {
			throw new ResourceException(HttpStatus.NOT_FOUND,"User not found");
		}
		return converter.toResponseDTO(user.get());
	}
	
	public User findUser(Long userId){
		Optional<User> user = repository.findById(userId);
		if(!user.isPresent()) {
			throw new ResourceException(HttpStatus.NOT_FOUND, "User not found");
		}
		return user.get();
	}
	
	
	public UserDTOResponse findByDocumentNumber(Long documentNumber){
		Optional<User> user = repository.findByDocumentNumber(documentNumber);
		if(!user.isPresent()) {
			throw new ResourceException(HttpStatus.NOT_FOUND, "User not found");
		}
		return converter.toResponseDTO(user.get());
	}
	
	public User findUserByDocumentNumber(Long documentNumber){
		Optional<User> user = repository.findByDocumentNumber(documentNumber);
		if(!user.isPresent()) {
			throw new ResourceException(HttpStatus.NOT_FOUND, "User not found");
		}
		return user.get();
	}
	
	public void delete(Long userId) {
		repository.deleteById(userId);
	}
}
