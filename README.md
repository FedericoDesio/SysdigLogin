GitHub page of the project:

https://github.com/FedericoDesio/SysdigLogin

Requirements:

To run this project, you need Java installed in your system. You can download it from: https://www.java.com/download/
You also need Chromedriver and Chrome browser: https://chromedriver.chromium.org/downloads

To Run the application with VS Code:

Open the Command Palette and run the task 'runTest', it will run all tests.

Login test case scenarios:

Login successful (positive/happy path), valid username and password,.
Logout successful (positive/happy path).
Login failed due to wrong credentials provided (negative), valid username, incorrect password.

Further test cases which should be added having more time:

1) Forgot password functionality.

2) Login using external accounts:
    - Google
    - SAML
    - OpenID

3) Verify the data center selection drop down and the system behaivor against the system requirements:
    - EU Central
    - US Est
    - US West

4) Negative scenarios: verify that the User is not able to Login with 
    - Empty username
    - Empty password
    - Invalid format username (not valid email format): check the system message

5) Creation of a free trial account.

6) Multi-browser compatibility (execute all tests at least in the most popular Browsers):
    - Firefox
    - Safari
    - MS Edge

Usability/Accessibility:

    Verify that once the login page is fully loaded, by default the username textbox has the focus (and the cursor).

    Verify it's possibile to navigate the different controls using the ‘Tab’ key on the keyboard.

    Verify that the username and password have the correct placeholder.

Security:

    Verify that there is a limit on the number of unsuccessful login attempts (according to the system requirements).

    Check if the password can be copy-pasted or not.

    Check if the password is masked when typed in the password field.

    Verify the username and password have a maximum limit of character (possibly flood attack).

    Verify whether the login page is vulnerable to SQL injection.

    Verify the session timeout after some minutes of inactivity (according to the system requirements)
