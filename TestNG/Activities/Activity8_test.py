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
    driver.find_element(By.ID, "menu_dashboard_index").click()
    driver.find_element(By.ID, "menu_leave_viewLeaveModule").click()
    driver.find_element(By.ID, "menu_leave_applyLeave").click()
    leave_type_dropdown = Select(driver.find_element(By.ID, "applyleave_txtLeaveType"))
    leave_type_dropdown.select_by_visible_text("Paid Leave")
    driver.find_element(By.ID, "applyleave_txtFromDate").send_keys("2024-07-01")
    driver.find_element(By.ID, "applyleave_txtToDate").send_keys("2024-07-03")
    driver.find_element(By.ID, "applyBtn").click()
    driver.find_element(By.ID, "menu_leave_viewMyLeaveList").click()
    print("Leave application submitted successfully.")
except NoSuchElementException as e:
    print(f"Element not found: {e}")

finally:
    driver.quit()
