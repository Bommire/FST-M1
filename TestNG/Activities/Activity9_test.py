from selenium import webdriver
from selenium.webdriver.common.by import By
from selenium.webdriver.firefox.options import Options
options = Options()
options.headless = True
driver = webdriver.Firefox(options=options)

try: 
    driver.get("http://alchemy.hguy.co/orangehrm/symfony/web/index.php/auth/login")
    username_field = driver.find_element(By.ID, "txtUsername")
    password_field = driver.find_element(By.ID, "txtPassword")
    username_field.send_keys("orange")  
    password_field.send_keys("orangepassword123") 
    driver.find_element(By.ID, "btnLogin").click()
    driver.find_element(By.ID, "menu_pim_viewMyDetails").click()
    driver.find_element(By.ID, "menu_pim_viewMyEmergencyContacts").click()
    contacts_table = driver.find_element(By.ID, "emgcontact_list")
    rows = contacts_table.find_elements(By.TAG_NAME, "tr")
    emergency_contacts = []
    for row in rows[1:]:  
        columns = row.find_elements(By.TAG_NAME, "td")
        if len(columns) >= 4:  
            name = columns[0].text
            relationship = columns[1].text
            home_phone = columns[2].text
            mobile_phone = columns[3].text

            contact_info = f"Name: {name}, Relationship: {relationship}, Home Phone: {home_phone}, Mobile Phone: {mobile_phone}"
            emergency_contacts.append(contact_info)
    for contact in emergency_contacts:
        print(contact)

except Exception as e:
    print(f"Exception occurred: {e}")

finally:
    driver.quit()
