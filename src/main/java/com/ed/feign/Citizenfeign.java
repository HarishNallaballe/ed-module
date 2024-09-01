package com.ed.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.ed.entity.Citizen;


@FeignClient(name="CITIZENS")
public interface Citizenfeign {
	
	@GetMapping("/citizen/{appNumber}")
	public ResponseEntity<Citizen> getCitizenByAppNumber(@PathVariable Integer appNumber);

}
