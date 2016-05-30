package com.robintegg.bnb.admin;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.robintegg.bnb.utils.UrlResolver;

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
	public String getPagesAdmin(HttpServletRequest request, ModelMap model) {

		List<PageThumbnail> listOfPages = adminService.getPageThumbnails();

		model.addAttribute("pages", listOfPages);
		model.addAttribute("urlResolver", new UrlResolver(request));

		return "admin/pages";

	}

	@RequestMapping(path = "/pages/{id}", method = RequestMethod.GET)
	public String getPageAdmin(@PathVariable("id") Long id, ModelMap model) {

		PageEditor editor = adminService.getPageEditor(id);

		model.addAttribute("editor", editor);

		return "admin/page";

	}

	@RequestMapping(path = "/pages/{id}", method = RequestMethod.POST)
	public String getSavePage(@PathVariable("id") Long id, @RequestParam Map<String, String> fields, ModelMap model) {

		System.out.println(fields);

		PageEditor editor = adminService.getPageEditor(id);

		model.addAttribute("editor", editor);

		return "admin/page";

	}

}
