package br.com.vivo.actionrecorder.converter;

import org.springframework.stereotype.Component;

import br.com.vivo.actionrecorder.dto.request.ConsumeLimitDTO;
import br.com.vivo.actionrecorder.dto.request.LineDTO;
import br.com.vivo.actionrecorder.dto.request.PlanDTO;
import br.com.vivo.actionrecorder.dto.response.LineDTOResponse;
import br.com.vivo.actionrecorder.entity.Line;

@Component
public class LineConverter implements EntityDTOConverter<LineDTO , Line ,  LineDTOResponse>{

	@Override
	public LineDTO toDTO(Line object) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Line toEntity(LineDTO object) {
		Line line =  new Line();
		line.setAreaCode(object.getAreaCode());
		line.setCountryCode(object.getCountryCode());
		line.setNumber(object.getNumber());
		return line;
	}

	@Override
	public LineDTOResponse toResponseDTO(Line object) {
		LineDTOResponse lineDTOResponse = new LineDTOResponse();
		lineDTOResponse.setId(object.getLineId());
		lineDTOResponse.setAreaCode(object.getAreaCode());
		lineDTOResponse.setCountryCode(object.getCountryCode());
		lineDTOResponse.setNumber(object.getNumber());
		PlanDTO planDTO = new PlanDTO();
		ConsumeLimitDTO consumeLimitDTO =  new ConsumeLimitDTO();
		consumeLimitDTO.setCall(object.getPlan().getCallLimit());
		consumeLimitDTO.setInternet(object.getPlan().getInternetLimit());
		consumeLimitDTO.setSms(object.getPlan().getSmsLimit());
		planDTO.setConsumeLimit(consumeLimitDTO);
		planDTO.setPrice(object.getPlan().getPrice());
		planDTO.setType(object.getPlan().getType());
		lineDTOResponse.setPlanDTO(planDTO);
		return lineDTOResponse;
	}

}
