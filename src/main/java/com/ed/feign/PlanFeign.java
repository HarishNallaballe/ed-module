package com.ed.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.ed.entity.Plan;

@FeignClient(name="PLANS-MODULE")
public interface PlanFeign {
	
	@GetMapping("/plan/{id}")
	public ResponseEntity<Plan> getPlanById(@PathVariable Integer id);

}
