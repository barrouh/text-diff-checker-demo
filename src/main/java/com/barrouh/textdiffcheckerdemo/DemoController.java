package com.barrouh.textdiffcheckerdemo;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.barrouh.textdiffchecker.TextDiffChecker;
import com.barrouh.textdiffchecker.beans.FinalDifferences;
import com.barrouh.textdiffchecker.beans.Utils;

@Controller
public class DemoController {

	static final Logger LOGGER = LogManager.getLogger(DemoController.class);

	private TextDiffChecker textDiffChecker = new  TextDiffChecker();
	
	private Utils  textDiffCheckerUtils = new Utils();
	
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
		
		FinalDifferences finalDiffs;
		
		String htmlResult="";
		ModelAndView model = new ModelAndView();
		
		LOGGER.info("Start Prossisng tow texts Differences");
		
		textDiffChecker.setChangedText(changedText);
		
		textDiffChecker.setOriginalText(originalText);
		
		finalDiffs=textDiffChecker.getFinalDifferences();
		
		htmlResult=textDiffCheckerUtils.convertToHtml(finalDiffs);	
		
		LOGGER.info("End  Prossisng tow texts Differences");
		
		model.setViewName("index");
		model.addObject("htmlResult", htmlResult);

		return model;

	}

}
