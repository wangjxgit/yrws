package com.share.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class hello {
	@RequestMapping("gg")
	public String hello(){
		return "hello";
	}
}
