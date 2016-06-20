package com.robintegg.bnb.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.robintegg.bnb.lodging.LodgingForm;
import com.robintegg.bnb.lodging.SingleLodgingService;

@Controller
@RequestMapping("/admin/lodging")
public class LodgingAdminController {

	private SingleLodgingService lodgingService;

	@Autowired
	public LodgingAdminController(SingleLodgingService lodgingService) {
		this.lodgingService = lodgingService;
	}

	@RequestMapping(method = RequestMethod.GET)
	public String getLodgingForm(ModelMap model) {
		model.addAttribute("lodgingForm", new LodgingForm(lodgingService.getLodging()));
		return "admin/lodging";
	}

	@RequestMapping(method = RequestMethod.POST)
	public String updateLodging(LodgingForm form, BindingResult result, ModelMap model) {
		if (result.hasErrors()) {
			return "admin/lodging";
		}
		lodgingService.submitForm(form);
		return "redirect:/admin/lodging";
	}

}
