package br.com.vivo.actionrecorder.converter;

import org.springframework.stereotype.Component;

import br.com.vivo.actionrecorder.dto.request.ActionDTO;
import br.com.vivo.actionrecorder.dto.response.ActionDTOResponse;
import br.com.vivo.actionrecorder.entity.Action;
import br.com.vivo.actionrecorder.entity.ServiceType;

@Component
public class ActionConverter implements EntityDTOConverter<ActionDTO , Action , ActionDTOResponse> {

	@Override
	public ActionDTO toDTO(Action object) {
		ActionDTO dto = new ActionDTO();
		dto.setServiceType(object.getServiceType().name());
		dto.setUsedData(object.getConsumedData());
		return dto;
	}

	@Override
	public Action toEntity(ActionDTO object) {
		Action action =  new Action();
		action.setConsumedData(object.getUsedData());
		action.setServiceType(ServiceType.valueOf(object.getServiceType()));
		return action;
	}

	@Override
	public ActionDTOResponse toResponseDTO(Action object) {
		ActionDTOResponse actionDTOResponse =  new ActionDTOResponse();
		actionDTOResponse.setId(object.getId());
		actionDTOResponse.setServiceType(object.getServiceType().name());
		actionDTOResponse.setUsedData(object.getConsumedData());
		return actionDTOResponse;
	}

}
