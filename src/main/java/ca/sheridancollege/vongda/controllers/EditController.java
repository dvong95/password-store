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
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import ca.sheridancollege.vongda.beans.PasswordRecord;
import ca.sheridancollege.vongda.database.DatabaseAccessImpl;

@Controller
public class EditController {
	@Autowired
	DatabaseAccessImpl da;

	@GetMapping("/editRecordById/{id}")
	public String editRecordById(Model model, @PathVariable Long id) {
		PasswordRecord record = da.getRecordListById(id).get(0);
		
		model.addAttribute("record", record);
		model.addAttribute("isUpdated", false);
		
		return "editRecordById";
	}
	
	@PostMapping("/updatePassword")
	public String updateRecord(Model model, @ModelAttribute PasswordRecord record) {
		da.updateRecord(record);
		
		model.addAttribute("isUpdated", "Record updated!");
		model.addAttribute("record", record);
		
		return "editRecordById";
	}
}
