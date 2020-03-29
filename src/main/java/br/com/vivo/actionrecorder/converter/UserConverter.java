package br.com.vivo.actionrecorder.converter;

import org.springframework.stereotype.Component;

import br.com.vivo.actionrecorder.dto.request.UserDTO;
import br.com.vivo.actionrecorder.dto.response.UserDTOResponse;
import br.com.vivo.actionrecorder.entity.User;

@Component
public class UserConverter implements EntityDTOConverter<UserDTO, User , UserDTOResponse>{

	@Override
	public UserDTO toDTO(User object) {
		UserDTO userDTO = new UserDTO();
		userDTO.setDocumentNumber(object.getDocumentNumber());
		userDTO.setFirstName(object.getFirstName());
		userDTO.setLastName(object.getLastName());
		return userDTO;
	}

	@Override
	public User toEntity(UserDTO object) {
		User user = new User();
		user.setDocumentNumber(object.getDocumentNumber());
		user.setFirstName(object.getFirstName());
		user.setLastName(object.getLastName());
		return user;
	}

	@Override
	public UserDTOResponse toResponseDTO(User object) {
		UserDTOResponse userDTOResponse = new UserDTOResponse();
		userDTOResponse.setDocumentNumber(object.getDocumentNumber());
		userDTOResponse.setFirstName(object.getFirstName());
		userDTOResponse.setLastName(object.getLastName());
		return userDTOResponse;
	}

}
