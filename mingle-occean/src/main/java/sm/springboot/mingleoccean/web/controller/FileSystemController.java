package sm.springboot.mingleoccean.web.controller;

import java.text.SimpleDateFormat;
import java.util.Date;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import sm.springboot.mingleoccean.web.model.File;
import sm.springboot.mingleoccean.web.service.FileSystemService;

@Controller
@SessionAttributes("name")
public class FileSystemController {

	@Autowired
	FileSystemService fileService;
	
	@InitBinder
	protected void initBinder(WebDataBinder binder) {
		SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
		binder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, false));
	}
	
	@RequestMapping(value="/mingle-ocean", method=RequestMethod.GET)
	public String fileSystem(ModelMap model) {
		model.put("files", fileService.retrieveFiles(0));
		
		return "fileSystem";
	}
	
	@RequestMapping(value="/add-file", method=RequestMethod.GET)
	public String addFile(ModelMap model) {
		model.addAttribute("file", new File(System.currentTimeMillis(), 0, "", (String) model.get("name"), new Date(), "File"));
		return "file";
	}
	
	@RequestMapping(value="/add-file", method=RequestMethod.POST)
	public String saveFile(ModelMap model, @Valid File file, BindingResult result) {		
		
		if (result.hasErrors()) {
			return "file";
		}
		
		fileService.addFile(new File(System.currentTimeMillis(), 0, file.getName(), (String) model.get("name"), new Date(), "File"));
		
		return "redirect:/mingle-ocean";
	}	
	
	@RequestMapping(value="/delete-file", method=RequestMethod.GET)
	public String deleteFile(@RequestParam long id) {
		if (id == 1) {
			throw new RuntimeException("This file can't be deleted");
		}
		fileService.remove(id);
		return "redirect:/mingle-ocean";
	}
	
	@RequestMapping(value="/update-file", method=RequestMethod.GET)
	public String updateFile(ModelMap model, @RequestParam long id) {
		model.put("file", fileService.retrieveFile(id));
		return "file";
	}
	
	@RequestMapping(value="/update-file", method=RequestMethod.POST)
	public String saveUpdatedFile(ModelMap model, File file) {
		fileService.remove(file.getId());
		
		fileService.addFile(new File(System.currentTimeMillis(), 0, file.getName(), (String) model.get("name"), file.getCreationDate(), "File"));
		return "redirect:/mingle-ocean";
	}
}
