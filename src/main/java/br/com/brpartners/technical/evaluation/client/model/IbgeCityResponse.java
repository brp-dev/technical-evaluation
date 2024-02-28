package br.com.brpartners.technical.evaluation.client.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class IbgeCityResponse {

	@JsonProperty("nome")
	String name;
}
