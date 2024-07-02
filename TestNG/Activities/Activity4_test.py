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
    driver.find_element(By.ID, "menu_pim_viewPimModule").click()
    driver.find_element(By.ID, "menu_pim_addEmployee").click()
    driver.find_element(By.ID, "firstName").send_keys("sucharitha")
    driver.find_element(By.ID, "lastName").send_keys("Bommireddy")
    username = "Suchreedy123"
    driver.find_element(By.ID, "user_name").send_keys(username)
    status_dropdown = Select(driver.find_element(By.ID, "status"))
    status_dropdown.select_by_visible_text("Enabled")
    driver.find_element(By.ID, "btnSave").click()
    driver.find_element(By.ID, "menu_pim_viewEmployeeList").click()
    driver.find_element(By.ID, "empsearch_employee_name_empName").send_keys("John Doe")
    driver.find_element(By.ID, "searchBtn").click()
    search_result = driver.find_element(By.XPATH, "//a[text()='sucharitha Bommireddy']").is_displayed()
    if search_result:
        print("Employee added successfully.")
    else:
        print("Employee not found. Verification failed.")
except NoSuchElementException as e:
    print(f"Element not found: {e}")
finally:
    driver.quit()
