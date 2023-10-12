/* 
 * David Vong
 * 991423258
 */
export const addFormFunction = () => {
    const passwords = document.querySelectorAll(".input-password");
    const passwordMatch = document.querySelector(".message");
    const submitButton = document.querySelector("#submitButton");

    passwords.forEach(password => {
        password.addEventListener("input", function () {
            if (passwords[0].value !== ""
                && passwords[0].value === passwords[1].value) {
                submitButton.removeAttribute("disabled");

            }

            if (passwords[0].value !== passwords[1].value)
                submitButton.setAttribute("disabled", "");

            if (passwords[1].value === ""
                || passwords[0].value === passwords[1].value) {
                const errorClass = passwords[1].getAttribute("class");
                const removeError = errorClass.replace(" error", "");

                passwords[1].setAttribute("class", removeError);
                passwordMatch.setAttribute("class", "message hidden");

            }

            if (passwords[1].value !== "" && passwords[0].value !== passwords[1].value) {
                passwords[1].setAttribute("class", "input-password error");
                passwordMatch.setAttribute("class", "message");

            }
        });
    });
}