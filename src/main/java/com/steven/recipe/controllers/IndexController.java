package com.steven.recipe.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * stevmc created on 2/15/20
 */
@Controller
public class IndexController {

	@RequestMapping({ "", "/", "/index" })
	public String getIndexPage() {
		return "index";
	}

}
