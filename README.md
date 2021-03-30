GitHub page of the project:

https://github.com/FedericoDesio/login-validation

Requirements:

To run this project, you need Java installed in your system. You can download it from: https://www.java.com/download/
You also need Chromedriver and Chrome browser: https://chromedriver.chromium.org/downloads

To Run the application with VS Code:

Open the Command Palette and run the task 'runTest', it will run all tests.

It will execute these scenarios of the Login test case:

Login successful (positive/happy path).
Logout successful (positive/happy path).
Login failed due to wrong credentials provided (negative).

Further test cases which should be added having more time:


1) Forgot your password functionality.

2) Login using external accounts:
    - Google
    - SAML
    - OpenID

3) Test he behaivor of the data center drop down against the system requirements:
    - EU Central
    - US Est
    - US West

4) Negative scenarios: verify that the User is not able to Login with 
    - Black username
    - Black password
    - Invalid format username (not valid email format): check the system notification

5) Creation of a free trial account.

6) Multi-browser compatibility:
    - Firefox
    - Safari
    - MS Edge

Usability:
Verify that once the login page is fully loaded, by default the username textbox has the focus.
Verify it's possibile to navigate the different controls using the ‘Tab’ key on the keyboard.
Verify that the username and password have the correct placeholder.

Security:
Verify that there is a limit on the number of unsuccessful login attempts (according to the system requirements)
Check if the password can be copy-pasted or not.
Check if the password is masked when typed in the password field.
Verify the username and password have a maximum limit of character (possibly flood attack).
Verify whether the login page is vulnerable to SQL injection
Verify the session timeout after some minutes of inactivity (according to the system requirements)