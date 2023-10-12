/* 
 * David Vong
 * 991423258
 */
import { addFormFunction } from "../utilities/addFormFunction.js";
import { toggleShowPasswordandReEnter } from "../utilities/passwordInput.js";

document.addEventListener("DOMContentLoaded", function () {
	addFormFunction();
	toggleShowPasswordandReEnter();
	
    //Edit only
    const editPasswordInput = document.querySelector(".edit-only");
    
    editPasswordInput.setAttribute("type", "password");
    editPasswordInput.setAttribute("class", "input-password");
});
