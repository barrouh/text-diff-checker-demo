package com.barrouh.textdiffcheckerdemo;

import java.util.Map;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.barrouh.textdiffchecker.TextDiffChecker;
import com.barrouh.textdiffchecker.beans.LineDifference;
import com.barrouh.textdiffchecker.utils.TextDiffCheckerUtils;

@Controller
public class DemoController {

	private static final Logger LOGGER = LogManager.getLogger(DemoController.class);
	
	private static final String DEFAULTVIEW="index";

	private TextDiffChecker textDiffChecker = new  TextDiffChecker();
	
	private TextDiffCheckerUtils  textDiffCheckerUtils = new TextDiffCheckerUtils();
	
	@GetMapping(value = "/")
	public String homePage(ModelMap model) {
		return DEFAULTVIEW;
	}

	@GetMapping(value = "/checkDiffs")
	public String findDiffsRefresh(ModelMap model) {
		return DEFAULTVIEW;
	}
	
	@PostMapping(value = "/checkDiffs")
	public ModelAndView findDiffs( 
			@RequestParam(value = "originalText", required = true) String originalText,
			@RequestParam(value = "changedText", required = true) String changedText) {
		
		Map<LineDifference, LineDifference> finalDiffs;
		
		String htmlResult="";
		ModelAndView model = new ModelAndView();
		
		LOGGER.info("Start Prossisng tow texts Differences");
		
		textDiffChecker.setChangedText(changedText);
		
		textDiffChecker.setOriginalText(originalText);
		
		finalDiffs=textDiffChecker.getFinalDifferences();
		
		htmlResult=textDiffCheckerUtils.convertToHtml(finalDiffs);	
		
		LOGGER.info("End  Prossisng tow texts Differences");
		
		model.setViewName(DEFAULTVIEW);
		
		model.addObject("htmlResult", htmlResult);
		
		//model.addObject("removals", textDiffChecker.getRemovals().toString());
		
		//model.addObject("additions", textDiffChecker.getAdditions().toString());
		
		model.addObject("originalText", originalText);
		
		model.addObject("changedText", changedText);

		return model;

	}

}
