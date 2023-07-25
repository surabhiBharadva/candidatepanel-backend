package com.example.candidatepanelbackend.Enum;

import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import java.util.Optional;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonFormat;

public enum PositionEnum {
	
	JavaDeveloper("Java Developer"), AngularDeveloper("Angular Developer"), FullStatckDeveloper("Full Statck Developer");

	
	private final String code;


	private PositionEnum(String code) {
		this.code = code;
	}

	public String getCode() {
		return code;
	}
	 
	@JsonCreator
	public static PositionEnum getDepartMentCode(String positionEnum) {
		for(PositionEnum posi : PositionEnum.values()) {
			if (posi.getCode().equals(positionEnum)) {
				 
                return posi;
            }	
		}
		return null;
	}

}
