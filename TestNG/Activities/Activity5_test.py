from selenium import webdriver
from selenium.webdriver.common.by import By
from selenium.webdriver.firefox.options import Options
from selenium.webdriver.support.ui import Select
from selenium.common.exceptions import NoSuchElementException
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
    driver.find_element(By.ID, "btnSave").click()
    driver.find_element(By.ID, "personal_txtEmpFirstName").clear()
    driver.find_element(By.ID, "personal_txtEmpFirstName").send_keys("Updated First Name")
    gender_dropdown = Select(driver.find_element(By.ID, "personal_cmbNation"))
    gender_dropdown.select_by_visible_text("Indian")
    nationality_dropdown = Select(driver.find_element(By.ID, "personal_cmbNation"))
    nationality_dropdown.select_by_visible_text("Indian")
    driver.find_element(By.ID, "personal_DOB").clear()
    driver.find_element(By.ID, "personal_DOB").send_keys("1999-10-01")
    driver.find_element(By.ID, "btnSave").click()
    print("User information edited successfully.")
except NoSuchElementException as e:
    print(f"Element not found: {e}")

finally:
    driver.quit()
