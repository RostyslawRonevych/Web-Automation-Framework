|id|summary|preconditions|steps|
| - | - | - | - |
|1|Successful Registration|None|1\. Fill in all fields with valid data. 2. Click the "Submit" button.|
|2|Minimum Required Fields|None|1\. Fill in only the first name, last name, email, password, and confirm password fields. 2. Click "Submit".|
|3|First Name Valid - Meets Requirements|None|1\. Enter a first name that contains only letters, is at least 2 characters long, and at most 100 characters long. 2. Click "Submit".|
|4|First Name Invalid - Too Short|None|1\. Enter a first name that is shorter than 2 characters. 2. Click "Submit".|
|5|First Name Invalid - Too Long|None|1\. Enter a first name that is longer than 100 characters. 2. Click "Submit".|
|6|First Name Invalid - Special Characters|None|1\. Enter a first name that contains special characters or digits. 2. Click "Submit".|
|7|Last Name Valid - Meets Requirements|None|1\. Enter a last name that contains only letters, is at least 2 characters long, and at most 100 characters long. 2. Click "Submit".|
|8|Last Name Invalid - Too Short|None|1\. Enter a last name that is shorter than 2 characters. 2. Click "Submit".|
|9|Last Name Invalid - Too Long|None|1\. Enter a last name that is longer than 100 characters. 2. Click "Submit".|
|10|Last Name Invalid - Special Characters|None|1\. Enter a last name that contains special characters or digits. 2. Click "Submit".|
|11|Valid Mobile Number|None|1\. Enter a valid mobile number with exactly 12 digits, starting with "380." 2. Click "Submit."|
|12|Valid Mobile Number with Optional '+'|None|1\. Enter a valid mobile number with exactly 12 digits, starting with "+380." 2. Click "Submit."|
|13|Empty Phone Number|None|1\. Leave the phone number field empty. 2. Click "Submit."|
|14|Invalid Mobile Number - Too Short|None|1\. Enter a mobile number with fewer than 12 digits. 2. Click "Submit."|
|15|Invalid Mobile Number - Invalid Characters|None|1\. Enter a mobile number containing characters other than numbers. 2. Click "Submit."|
|16|Invalid Mobile Number - Incorrect Prefix|None|1\. Enter a mobile number with exactly 12 digits but doesn't start with "380." 2. Click "Submit."|
|17|Invalid Mobile Number - Too Long|None|1\. Enter a mobile number longer than 12 digits. 2. Click "Submit."|
|18|Invalid Mobile Number - Mixed with Special Characters|None|1\. Enter a mobile number with mixed numbers and special characters. 2. Click "Submit."|
|19|Invalid Mobile Number - Missing '+' for Optional Prefix|None|1\. Enter a mobile number with the "380" prefix but without the optional '+' at the beginning. 2. Click "Submit."|
|20|Valid Email Address|None|1\. Enter a valid email address. 2. Click "Submit."|
|21|Invalid Email Address|None|1\. Enter an email address without "@" or without a top-level domain. 2. Click "Submit".|
|22|Email Already Registered|A user with the same email already exists.|1\. Enter an email address that is already in use. 2. Click "Submit".|
|23|Gender Dropdown Validation|None|1\. Select an option from the gender dropdown. 2. Click "Submit".|
|24|Language Dropdown Validation|None|1\. Select an option from the language dropdown. 2. Click "Submit".|
|25|Category Dropdown Validation|None|1\. Select an option from the category dropdown. 2. Click "Submit".|
|26|Category Dropdown Validation|None|1\. Do not select any option from the category dropdown. 2. Click "Submit".|
|27|Password Too Short|None|1\. Enter a password that is shorter than the required minimum length. 2. Click "Submit".|
|28|Password Mismatch|None|1\. Enter a password and confirm password that don't match. 2. Click "Submit".|
|29|Valid Password - Meets Requirements|None|1\. Enter a password that contains at least 2 capital letters, 2 lower case letters, 1 special symbol, and is 8-100 characters long. 2. Click "Submit."|
|30|Password Invalid - Missing Capital Letters|None|1\. Enter a password that lacks at least 2 capital letters. 2. Click "Submit".|
|31|Password Invalid - Missing Lower Case Letters|None|1\. Enter a password that lacks at least 2 lower case letters. 2. Click "Submit".|
|32|Password Invalid - Missing Special Symbol|None|1\. Enter a password that lacks a special symbol. 2. Click "Submit".|
|33|Password Invalid - Too Short|None|1\. Enter a password that is shorter than 8 characters. 2. Click "Submit".|
|34|Password Invalid - Too Long|None|1\. Enter a password that is longer than 100 characters. 2. Click "Submit".|
|35|Successful Registration with About Section|None|1\. Fill in all fields with valid data, including the "about" field (the field accepts all characters, max length 100 characters). 2. Click "Submit".|
|36|Successful Registration without About Section|None|1\. Fill in all fields with valid data, without the "about" field. 2. Click "Submit".|
|37|Empty Form Submission|None|1\. Leave all fields empty. 2. Click "Submit".|



|expected result|
| - |
|User is successfully registered, and a confirmation message is displayed.|
|User is successfully registered, and a confirmation message is displayed.|
|User is successfully registered, and a confirmation message is displayed.|
|An error message is displayed, indicating the first name is too short.|
|An error message is displayed, indicating the first name is too long.|
|An error message is displayed, indicating the first name contains invalid characters.|
|User is successfully registered, and a confirmation message is displayed.|
|An error message is displayed, indicating the last name is too short.|
|An error message is displayed, indicating the last name is too long.|
|An error message is displayed, indicating the last name contains invalid characters.|
|User is successfully registered, and a confirmation message is displayed.|
|User is successfully registered, and a confirmation message is displayed.|
|User is successfully registered, and a confirmation message is displayed.|
|An error message is displayed, indicating that the phone number is too short.|
|An error message is displayed, indicating that the phone number contains invalid characters.|
|An error message is displayed, indicating that the phone number should start with "380."|
|An error message is displayed, indicating that the phone number is too long.|
|An error message is displayed, indicating that the phone number contains invalid characters.|
|User is successfully registered, and a confirmation message is displayed.|
|User is successfully registered, and a confirmation message is displayed.|
|An error message is displayed, indicating an invalid email address.|
|An error message is displayed, indicating that the email is already registered.|
|User is successfully registered with the selected gender.|
|User is successfully registered with the selected language.|
|User is successfully registered with the selected category.|
|User is successfully registered|
|An error message is displayed, indicating the password is too short.|
|An error message is displayed, indicating a password mismatch.|
|User is successfully registered, and a confirmation message is displayed.|
|An error message is displayed, indicating the password requirements are not met.|
|An error message is displayed, indicating the password requirements are not met.|
|An error message is displayed, indicating the password requirements are not met.|
|An error message is displayed, indicating the password is too short.|
|An error message is displayed, indicating the password is too long.|
|User is successfully registered, and a confirmation message is displayed.|
|User is successfully registered, and a confirmation message is displayed.|
|Error messages are displayed for each required field, indicating they are empty.|



|id|summary|preconditions|
| - | - | - |
|1|Successful Registration|None|
|2|Minimum Required Fields|None|
|3|First Name Valid - Meets Requirements|None|
|4|First Name Invalid - Too Short|None|
|5|First Name Invalid - Too Long|None|
|6|First Name Invalid - Special Characters|None|
|7|Last Name Valid - Meets Requirements|None|
|8|Last Name Invalid - Too Short|None|
|9|Last Name Invalid - Too Long|None|
|10|Last Name Invalid - Special Characters|None|
|11|Valid Mobile Number|None|
|12|Valid Mobile Number with Optional '+'|None|
|13|Empty Phone Number|None|
|14|Invalid Mobile Number - Too Short|None|
|15|Invalid Mobile Number - Invalid Characters|None|
|16|Invalid Mobile Number - Incorrect Prefix|None|
|17|Invalid Mobile Number - Too Long|None|
|18|Invalid Mobile Number - Mixed with Special Characters|None|
|19|Invalid Mobile Number - Missing '+' for Optional Prefix|None|
|20|Valid Email Address|None|
|21|Invalid Email Address|None|
|22|Email Already Registered|A user with the same email already exists.|
|23|Password Too Short|None|
|24|Password Mismatch|None|
|25|Valid Password - Meets Requirements|None|
|26|Password Invalid - Missing Capital Letters|None|
|27|Password Invalid - Missing Lower Case Letters|None|
|28|Password Invalid - Missing Special Symbol|None|
|29|Password Invalid - Too Short|None|
|30|Password Invalid - Too Long|None|
|31|Successful Registration with About Section|None|
|32|Successful Registration without About Section|None|
|33|Empty Form Submission|None|
|34|Valid Organization Name|None|
|35|Empty Organization Name|None|
|36|Invalid Organization Name (Special Characters)|None|
|37|Invalid Organization Name (Too Long)|None|
|38|Valid Position|None|
|39|Empty Position|None|
|40|Invalid Position (Special Characters)|None|
|41|Invalid Position (Too Long)|None|



|42|Valid Organization Website Link|None|
| - | - | - |
|43|Invalid Organization Website Link (Not a URL)|None|
|44|Empty Organization Website Link|None|
|45|Valid About Organization|None|
|46|Invalid About Organization (Special Characters)|None|
|47|Empty About Organization|None|
|48|Valid Registry Link|None|
|49|Invalid Registry Link (Not a URL)|None|
|50|Empty Registry Link|None|



|steps|expected result|
| - | - |
|1\. Fill in all fields with valid data. 2. Click the "Submit" button.|User is successfully registered, and a confirmation message is displayed.|
|1\. Fill in only the first name, last name, email, password, and confirm password fields. 2. Click "Submit".|User is successfully registered, and a confirmation message is displayed.|
|1\. Enter a first name that contains only letters, is at least 2 characters long, and at most 100 characters long. 2. Click "Submit".|User is successfully registered, and a confirmation message is displayed.|
|1\. Enter a first name that is shorter than 2 characters. 2. Click "Submit".|An error message is displayed, indicating the first name is too short.|
|1\. Enter a first name that is longer than 100 characters. 2. Click "Submit".|An error message is displayed, indicating the first name is too long.|
|1\. Enter a first name that contains special characters or digits. 2. Click "Submit".|An error message is displayed, indicating the first name contains invalid characters.|
|1\. Enter a last name that contains only letters, is at least 2 characters long, and at most 100 characters long. 2. Click "Submit".|User is successfully registered, and a confirmation message is displayed.|
|1\. Enter a last name that is shorter than 2 characters. 2. Click "Submit".|An error message is displayed, indicating the last name is too short.|
|1\. Enter a last name that is longer than 100 characters. 2. Click "Submit".|An error message is displayed, indicating the last name is too long.|
|1\. Enter a last name that contains special characters or digits. 2. Click "Submit".|An error message is displayed, indicating the last name contains invalid characters.|
|1\. Enter a valid mobile number with exactly 12 digits, starting with "380." 2. Click "Submit."|User is successfully registered, and a confirmation message is displayed.|
|1\. Enter a valid mobile number with exactly 12 digits, starting with "+380." 2. Click "Submit."|User is successfully registered, and a confirmation message is displayed.|
|1\. Leave the phone number field empty. 2. Click "Submit."|User is successfully registered, and a confirmation message is displayed.|
|1\. Enter a mobile number with fewer than 12 digits. 2. Click "Submit."|An error message is displayed, indicating that the phone number is too short.|
|1\. Enter a mobile number containing characters other than numbers. 2. Click "Submit."|An error message is displayed, indicating that the phone number contains invalid characters.|
|1\. Enter a mobile number with exactly 12 digits but doesn't start with "380." 2. Click "Submit."|An error message is displayed, indicating that the phone number should start with "380."|
|1\. Enter a mobile number longer than 12 digits. 2. Click "Submit."|An error message is displayed, indicating that the phone number is too long.|
|1\. Enter a mobile number with mixed numbers and special characters. 2. Click "Submit."|An error message is displayed, indicating that the phone number contains invalid characters.|
|1\. Enter a mobile number with the "380" prefix but without the optional '+' at the beginning. 2. Click "Submit."|User is successfully registered, and a confirmation message is displayed.|
|1\. Enter a valid email address. 2. Click "Submit."|User is successfully registered, and a confirmation message is displayed.|
|1\. Enter an email address without "@" or without a top-level domain. 2. Click "Submit".|An error message is displayed, indicating an invalid email address.|
|1\. Enter an email address that is already in use. 2. Click "Submit".|An error message is displayed, indicating that the email is already registered.|
|1\. Enter a password that is shorter than the required minimum length. 2. Click "Submit".|An error message is displayed, indicating the password is too short.|
|1\. Enter a password and confirm password that don't match. 2. Click "Submit".|An error message is displayed, indicating a password mismatch.|
|1\. Enter a password that contains at least 2 capital letters, 2 lower case letters, 1 special symbol, and is 8-100 characters long. 2. Click "Submit."|User is successfully registered, and a confirmation message is displayed.|
|1\. Enter a password that lacks at least 2 capital letters. 2. Click "Submit".|An error message is displayed, indicating the password requirements are not met.|
|1\. Enter a password that lacks at least 2 lower case letters. 2. Click "Submit".|An error message is displayed, indicating the password requirements are not met.|
|1\. Enter a password that lacks a special symbol. 2. Click "Submit".|An error message is displayed, indicating the password requirements are not met.|
|1\. Enter a password that is shorter than 8 characters. 2. Click "Submit".|An error message is displayed, indicating the password is too short.|
|1\. Enter a password that is longer than 100 characters. 2. Click "Submit".|An error message is displayed, indicating the password is too long.|
|1\. Fill in all fields with valid data, including the "about" field (the field accepts all characters, max length 100 characters). 2. Click "Submit".|User is successfully registered, and a confirmation message is displayed.|
|1\. Fill in all fields with valid data, without the "about" field. 2. Click "Submit".|User is successfully registered, and a confirmation message is displayed.|
|1\. Leave all fields empty. 2. Click "Submit".|Error messages are displayed for each required field, indicating they are empty.|
|1\. Enter a valid organization name (e.g., "ABC Inc"). 2. Click "Submit."|User is successfully registered, and a confirmation message is displayed.|
|1\. Leave the organization name field empty. 2. Click "Submit."|An error message is displayed, indicating that the organization name is required.|
|1\. Enter an organization name containing special characters (e.g., "ABC Inc & Co"). 2. Click "Submit."|An error message is displayed, indicating that the organization name contains invalid characters.|
|1\. Enter an organization name longer than 100 characters. 2. Click "Submit."|An error message is displayed, indicating that the organization name is too long.|
|1\. Enter a valid position (e.g., "Manager"). 2. Click "Submit."|User is successfully registered, and a confirmation message is displayed.|
|1\. Leave the position field empty. 2. Click "Submit."|An error message is displayed, indicating that the position is required.|
|1\. Enter a position containing special characters (e.g., "Manager & Director"). 2. Click "Submit."|An error message is displayed, indicating that the position contains invalid characters.|
|1\. Enter a position longer than 100 characters. 2. Click "Submit."|An error message is displayed, indicating that the position is too long.|



|1\. Enter a valid organization website link. 2. Click "Submit."|User is successfully registered, and a confirmation message is displayed.|
| - | - |
|1\. Enter an invalid organization website link (e.g., "example"). 2. Click "Submit."|An error message is displayed, indicating that the organization website link is not a valid URL.|
|1\. Leave the organization website link field empty. 2. Click "Submit."|User is successfully registered, and a confirmation message is displayed.|
|1\. Enter a valid about organization description. 2. Click "Submit."|User is successfully registered, and a confirmation message is displayed.|
|1\. Enter an about organization description containing special characters (e.g., "Our Company & Services"). 2. Click "Submit."|An error message is displayed, indicating that the about organization description contains invalid characters.|
|1\. Leave the about organization field empty. 2. Click "Submit."|User is successfully registered, and a confirmation message is displayed.|
|1\. Enter a valid registry link. 2. Click "Submit."|User is successfully registered, and a confirmation message is displayed.|
|1\. Enter an invalid registry link (e.g., "example"). 2. Click "Submit."|An error message is displayed, indicating that the registry link is not a valid URL.|
|1\. Leave the registry link field empty. 2. Click "Submit."|User is successfully registered, and a confirmation message is displayed.|



|id|summary|preconditions|
| - | - | - |
|1|Successful Registration|None|
|2|Minimum Required Fields|None|
|3|First Name Valid - Meets Requirements|None|
|4|First Name Invalid - Too Short|None|
|5|First Name Invalid - Too Long|None|
|6|First Name Invalid - Special Characters|None|
|7|Last Name Valid - Meets Requirements|None|
|8|Last Name Invalid - Too Short|None|
|9|Last Name Invalid - Too Long|None|
|10|Last Name Invalid - Special Characters|None|
|11|Valid Mobile Number|None|
|12|Valid Mobile Number with Optional '+'|None|
|13|Empty Phone Number|None|
|14|Invalid Mobile Number - Too Short|None|
|15|Invalid Mobile Number - Invalid Characters|None|
|16|Invalid Mobile Number - Incorrect Prefix|None|
|17|Invalid Mobile Number - Too Long|None|
|18|Invalid Mobile Number - Mixed with Special Characters|None|
|19|Invalid Mobile Number - Missing '+' for Optional Prefix|None|
|20|Valid Email Address|None|
|21|Invalid Email Address|None|
|21|Invalid Email Address (not corporate email)|None|
|22|Email Already Registered|A user with the same email already exists.|
|23|Password Too Short|None|
|24|Password Mismatch|None|
|25|Valid Password - Meets Requirements|None|
|26|Password Invalid - Missing Capital Letters|None|
|27|Password Invalid - Missing Lower Case Letters|None|
|28|Password Invalid - Missing Special Symbol|None|
|29|Password Invalid - Too Short|None|
|30|Password Invalid - Too Long|None|
|31|Successful Registration with About Section|None|
|32|Successful Registration without About Section|None|
|33|Empty Form Submission|None|
|34|Valid Organization Name|None|
|35|Empty Organization Name|None|
|36|Invalid Organization Name (Special Characters)|None|
|37|Invalid Organization Name (Too Long)|None|
|38|Valid Position|None|
|39|Empty Position|None|
|40|Invalid Position (Special Characters)|None|



|41|Invalid Position (Too Long)|None|
| - | :- | :- |
|42|Valid Organization Website Link|None|
|43|Invalid Organization Website Link (Not a URL)|None|
|44|Empty Organization Website Link|None|
|45|Valid About Organization|None|
|46|Invalid About Organization (Special Characters)|None|
|47|Empty About Organization|None|
||||
||||
||||


|steps|expected result|
| - | - |
|1\. Fill in all fields with valid data. 2. Click the "Submit" button.|User is successfully registered, and a confirmation message is displayed.|
|1\. Fill in only the first name, last name, email, password, and confirm password fields. 2. Click "Submit".|User is successfully registered, and a confirmation message is displayed.|
|1\. Enter a first name that contains only letters, is at least 2 characters long, and at most 100 characters long. 2. Click "Submit".|User is successfully registered, and a confirmation message is displayed.|
|1\. Enter a first name that is shorter than 2 characters. 2. Click "Submit".|An error message is displayed, indicating the first name is too short.|
|1\. Enter a first name that is longer than 100 characters. 2. Click "Submit".|An error message is displayed, indicating the first name is too long.|
|1\. Enter a first name that contains special characters or digits. 2. Click "Submit".|An error message is displayed, indicating the first name contains invalid characters.|
|1\. Enter a last name that contains only letters, is at least 2 characters long, and at most 100 characters long. 2. Click "Submit".|User is successfully registered, and a confirmation message is displayed.|
|1\. Enter a last name that is shorter than 2 characters. 2. Click "Submit".|An error message is displayed, indicating the last name is too short.|
|1\. Enter a last name that is longer than 100 characters. 2. Click "Submit".|An error message is displayed, indicating the last name is too long.|
|1\. Enter a last name that contains special characters or digits. 2. Click "Submit".|An error message is displayed, indicating the last name contains invalid characters.|
|1\. Enter a valid mobile number with exactly 12 digits, starting with "380." 2. Click "Submit."|User is successfully registered, and a confirmation message is displayed.|
|1\. Enter a valid mobile number with exactly 12 digits, starting with "+380." 2. Click "Submit."|User is successfully registered, and a confirmation message is displayed.|
|1\. Leave the phone number field empty. 2. Click "Submit."|User is successfully registered, and a confirmation message is displayed.|
|1\. Enter a mobile number with fewer than 12 digits. 2. Click "Submit."|An error message is displayed, indicating that the phone number is too short.|
|1\. Enter a mobile number containing characters other than numbers. 2. Click "Submit."|An error message is displayed, indicating that the phone number contains invalid characters.|
|1\. Enter a mobile number with exactly 12 digits but doesn't start with "380." 2. Click "Submit."|An error message is displayed, indicating that the phone number should start with "380."|
|1\. Enter a mobile number longer than 12 digits. 2. Click "Submit."|An error message is displayed, indicating that the phone number is too long.|
|1\. Enter a mobile number with mixed numbers and special characters. 2. Click "Submit."|An error message is displayed, indicating that the phone number contains invalid characters.|
|1\. Enter a mobile number with the "380" prefix but without the optional '+' at the beginning. 2. Click "Submit."|User is successfully registered, and a confirmation message is displayed.|
|1\. Enter a valid email address. 2. Click "Submit."|User is successfully registered, and a confirmation message is displayed.|
|1\. Enter an email address without "@" or without a top-level domain. 2. Click "Submit".|An error message is displayed, indicating an invalid email address.|
|1\. Enter an email address which is not in the member list of the organization. 2. Click "Submit".|An error message is displayed, indicating an invalid email address.|
|1\. Enter an email address that is already in use. 2. Click "Submit".|An error message is displayed, indicating that the email is already registered.|
|1\. Enter a password that is shorter than the required minimum length. 2. Click "Submit".|An error message is displayed, indicating the password is too short.|
|1\. Enter a password and confirm password that don't match. 2. Click "Submit".|An error message is displayed, indicating a password mismatch.|
|1\. Enter a password that contains at least 2 capital letters, 2 lower case letters, 1 special symbol, and is 8-100 characters long. 2. Click "Submit."|User is successfully registered, and a confirmation message is displayed.|
|1\. Enter a password that lacks at least 2 capital letters. 2. Click "Submit".|An error message is displayed, indicating the password requirements are not met.|
|1\. Enter a password that lacks at least 2 lower case letters. 2. Click "Submit".|An error message is displayed, indicating the password requirements are not met.|
|1\. Enter a password that lacks a special symbol. 2. Click "Submit".|An error message is displayed, indicating the password requirements are not met.|
|1\. Enter a password that is shorter than 8 characters. 2. Click "Submit".|An error message is displayed, indicating the password is too short.|
|1\. Enter a password that is longer than 100 characters. 2. Click "Submit".|An error message is displayed, indicating the password is too long.|
|1\. Fill in all fields with valid data, including the "about" field (the field accepts all characters, max length 100 characters). 2. Click "Submit".|User is successfully registered, and a confirmation message is displayed.|
|1\. Fill in all fields with valid data, without the "about" field. 2. Click "Submit".|User is successfully registered, and a confirmation message is displayed.|
|1\. Leave all fields empty. 2. Click "Submit".|Error messages are displayed for each required field, indicating they are empty.|
|1\. Enter a valid organization name (e.g., "ABC Inc"). 2. Click "Submit."|User is successfully registered, and a confirmation message is displayed.|
|1\. Leave the organization name field empty. 2. Click "Submit."|An error message is displayed, indicating that the organization name is required.|
|1\. Enter an organization name containing special characters (e.g., "ABC Inc & Co"). 2. Click "Submit."|An error message is displayed, indicating that the organization name contains invalid characters.|
|1\. Enter an organization name longer than 100 characters. 2. Click "Submit."|An error message is displayed, indicating that the organization name is too long.|
|1\. Enter a valid position (e.g., "Manager"). 2. Click "Submit."|User is successfully registered, and a confirmation message is displayed.|
|1\. Leave the position field empty. 2. Click "Submit."|An error message is displayed, indicating that the position is required.|
|1\. Enter a position containing special characters (e.g., "Manager & Director"). 2. Click "Submit."|An error message is displayed, indicating that the position contains invalid characters.|



|1\. Enter a position longer than 100 characters. 2. Click "Submit."|An error message is displayed, indicating that the position is too long.|
| :- | :- |
|1\. Enter a valid organization website link. 2. Click "Submit."|User is successfully registered, and a confirmation message is displayed.|
|1\. Enter an invalid organization website link (e.g., "example"). 2. Click "Submit."|An error message is displayed, indicating that the organization website link is not a valid URL.|
|1\. Leave the organization website link field empty. 2. Click "Submit."|User is successfully registered, and a confirmation message is displayed.|
|1\. Enter a valid about organization description. 2. Click "Submit."|User is successfully registered, and a confirmation message is displayed.|
|1\. Enter an about organization description containing special characters (e.g., "Our Company & Services"). 2. Click "Submit."|An error message is displayed, indicating that the about organization description contains invalid characters.|
|1\. Leave the about organization field empty. 2. Click "Submit."|User is successfully registered, and a confirmation message is displayed.|
|||
|||
|||

