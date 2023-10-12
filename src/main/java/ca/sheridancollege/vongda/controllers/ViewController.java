/* 
 * David Vong
 * 991423258
 */
package ca.sheridancollege.vongda.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import ca.sheridancollege.vongda.database.DatabaseAccessImpl;

@Controller
public class ViewController {
	@Autowired
	DatabaseAccessImpl da;

    @GetMapping("/viewPasswordRecord")
    public String viewPasswordRecord(Model model) {
        model.addAttribute("recordList", da.getRecordList());

        return "viewPasswordRecord";
    }
}
