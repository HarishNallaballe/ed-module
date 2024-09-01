package com.ed.feign;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.ed.entity.Income;
import com.ed.entity.Kid;

@FeignClient(name="DC-MODULE")
public interface IncomeFeign {
	
	@GetMapping("/inco/{appNumber}")
	public ResponseEntity<Income> getIncomeByAppNumber(@PathVariable Integer appNumber);
	
	@GetMapping("/kid/appnumber/{appNumber}")
	public ResponseEntity<List<Kid>> getKidByAppNumber(@PathVariable Integer appNumber);

}
