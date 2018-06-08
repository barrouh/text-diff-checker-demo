package com.barrouh.textdiffcheckerdemo;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class DemoController {

	final static Logger LOGGER = LogManager.getLogger(DemoController.class);

	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String homePage(ModelMap model) {
		return "index";
	}

	@RequestMapping(value = "/checkDiffs", method = RequestMethod.GET)
	public String findDiffsRefresh(ModelMap model) {
		return "index";
	}
	
	@RequestMapping(value = "/checkDiffs", method = RequestMethod.POST)
	public ModelAndView findDiffs( 
			@RequestParam(value = "originalText", required = true) String originalText,
			@RequestParam(value = "changedText", required = true) String changedText) {
		String htmlResult="";
		ModelAndView model = new ModelAndView();
		
		System.out.println(originalText);
		System.out.println(changedText);
		
		model.setViewName("index");
		model.addObject("msg", htmlResult);

		return model;

	}

}
