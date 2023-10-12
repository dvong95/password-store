/* 
 * David Vong
 * 991423258
 */
package ca.sheridancollege.vongda.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import ca.sheridancollege.vongda.database.DatabaseAccessImpl;

@Controller
public class DeleteController {
	@Autowired
	DatabaseAccessImpl da;

	@GetMapping("/viewPasswordRecord/{id}")
	public String deleteStudentById(Model model, @PathVariable Long id) {
		da.deleteRecordById(id);
		
		model.addAttribute("recordList", da.getRecordList());
		
		return "viewPasswordRecord";
	}
}
