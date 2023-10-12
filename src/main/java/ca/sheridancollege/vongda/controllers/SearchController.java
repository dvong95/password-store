/* 
 * David Vong
 * 991423258
 */
package ca.sheridancollege.vongda.controllers;

import java.util.regex.Pattern;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import ca.sheridancollege.vongda.beans.PasswordRecord;
import ca.sheridancollege.vongda.database.DatabaseAccessImpl;

@Controller
public class SearchController {
    @Autowired
    DatabaseAccessImpl da;

    @GetMapping("/searchPasswordRecord")
    public String searchPasswordRecord(Model model) {
    	
        model.addAttribute("id", null);
        
        //Hide table
        model.addAttribute("hasSearched", false);

        return "searchPasswordRecord";
    }

    @PostMapping("/searchResult")
    public String searchResult(@RequestParam String searchID, Model model) {
        // Validation that user only input numbers
    	//Input must begin(^) and end($) with 0-9([0-9]. From one to more numbers(+)
        Pattern numbersOnly = Pattern.compile("^[0-9]+$");
        PasswordRecord result = null;

        if (numbersOnly.matcher(searchID).matches()) {
            for (PasswordRecord record : da.getRecordList()) {
                if (record.getId().equals(Long.valueOf(searchID)))
                    result = record;
            }
        }

        model.addAttribute("result", result);
        //Show table
        model.addAttribute("hasSearched", true);

        return "searchPasswordRecord";
    }

}
