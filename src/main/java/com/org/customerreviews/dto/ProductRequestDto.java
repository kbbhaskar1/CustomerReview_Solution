package com.org.customerreviews.dto;

import javax.validation.constraints.NotNull;
import org.hibernate.validator.constraints.NotEmpty;

import com.fasterxml.jackson.annotation.JsonProperty;




public class ProductRequestDto {
	@NotNull
	@NotEmpty
	@JsonProperty("name")
	private String name;
	
	//getters
	public String getName(){
		return this.name;
	}
	
	//setters
	public void setName(String name){
		this.name = name;
	}
}
