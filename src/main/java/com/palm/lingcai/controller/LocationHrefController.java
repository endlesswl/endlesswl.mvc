package com.palm.lingcai.controller;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

/**
 * @Title:
 * @Description:
 * @Author nzh
 */
@Controller
@RequestMapping(value = "/location")
public class LocationHrefController {

	private static Logger logger = LoggerFactory.getLogger(LocationHrefController.class);

	@SuppressWarnings("unchecked")
	@RequestMapping(method = RequestMethod.GET)
	public String path(HttpServletRequest request, 
			@RequestParam(value = "path", required = true) String path,
			@RequestParam(value = "redirectUrl", required = false) String redirectUrl,
			@RequestParam(value = "locationFlag",required = false, defaultValue = "false") String localtionFlag,
			Model model) {

		logger.info("location");
		logger.info(path);
		try {
			Map<String, String[]> map = request.getParameterMap();
			Set<Entry<String, String[]>> set = map.entrySet();
			Iterator<Entry<String, String[]>> it = set.iterator();
			while (it.hasNext()) {
				Entry<String, String[]> entry = it.next();
				logger.info("======  key={}, value={}  ======", entry.getKey(), entry.getValue()[0]);
				model.addAttribute(entry.getKey(), entry.getValue()[0]);

			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return path;
	}
}
