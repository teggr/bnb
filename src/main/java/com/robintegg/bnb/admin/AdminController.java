package com.robintegg.bnb.admin;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Order(Ordered.HIGHEST_PRECEDENCE)
@Controller
@RequestMapping("/admin")
public class AdminController {

	private AdminService adminService;

	@Autowired
	public AdminController(AdminService adminService) {
		this.adminService = adminService;
	}

	@RequestMapping(method = RequestMethod.GET)
	public String getAdmin() {
		return "redirect:/admin/pages";
	}
	
	@RequestMapping(path = "/images", method = RequestMethod.GET)
	public String getImagesAdmin(ModelMap model) {

		List<PageThumbnail> listOfPages = adminService.getPageThumbnails();

		model.addAttribute("pages", listOfPages);

		return "admin/images";

	}

	@RequestMapping(path = "/pages", method = RequestMethod.GET)
	public String getPagesAdmin(ModelMap model) {

		List<PageThumbnail> listOfPages = adminService.getPageThumbnails();

		model.addAttribute("pages", listOfPages);

		return "admin/pages";

	}

	@RequestMapping(path = "/pages/{id}", method = RequestMethod.GET)
	public String getPageAdmin(@PathVariable("id") Long id, ModelMap model) {

		PageEditor editor = adminService.getPageEditor(id);

		model.addAttribute("editor", editor);

		return "admin/page";

	}

}
