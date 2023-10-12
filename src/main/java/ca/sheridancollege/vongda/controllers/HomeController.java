/* 
 * David Vong
 * 991423258
 */
package ca.sheridancollege.vongda.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import ca.sheridancollege.vongda.beans.PasswordRecord;
import ca.sheridancollege.vongda.database.DatabaseAccessImpl;
import ca.sheridancollege.vongda.utilities.RandomNumberGenerator;

@Controller
public class HomeController {
	@Autowired
	DatabaseAccessImpl da;

	@GetMapping("/")
	public String index(Model model) {
		PasswordRecord record = new PasswordRecord();
		
		//Auto-generate ID
		record.setId(RandomNumberGenerator.generateID(da));
		
		model.addAttribute("record", record);
		model.addAttribute("isAdded", false); //Hide added message

		return "index";
	}

	@PostMapping("/addPassword")
	public String addPassword(Model model, @ModelAttribute PasswordRecord record) {
		da.insertRecord(record);
		//Display Message
		model.addAttribute("isAdded", "Password added successfully!");
			

		record = new PasswordRecord();
		
		//Auto-generate ID
		record.setId(RandomNumberGenerator.generateID(da));
		
		model.addAttribute("record", record);

		return "index";
	}
}
