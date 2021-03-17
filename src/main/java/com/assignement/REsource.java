package com.assignement;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class REsource {

	@GetMapping("lala")
	public String lala() {
		return "lala";
	}
}
