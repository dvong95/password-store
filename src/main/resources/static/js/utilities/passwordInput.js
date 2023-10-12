/* 
 * David Vong
 * 991423258
 */
export const toggleShowPassword = checkbox => {
    const passwordInput = checkbox.closest("tr").querySelector(".input-password");

    if (checkbox.checked) {
        passwordInput.type = "text";

    } else {
        passwordInput.type = "password";

    }
}

export const showPasswords = () => {
    const showPasswordCheckboxes = document.querySelectorAll(".cb-password");

    showPasswordCheckboxes.forEach(checkbox => {
        checkbox.addEventListener("change", function () {
            toggleShowPassword(checkbox)
        });
    });
}

export const toggleShowPasswordandReEnter = () => {
    const showPasswordCheckbox = document.querySelector(".cb-password");
    const passwordInputs = document.querySelectorAll(".input-password");

    showPasswordCheckbox.addEventListener("change", function () {
        passwordInputs.forEach(input => {
            if (showPasswordCheckbox.checked) {
                input.type = "text";

            } else {
                input.type = "password";

            }
        });
    });


}