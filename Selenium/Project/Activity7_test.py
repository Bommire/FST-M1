from selenium import webdriver
from selenium.webdriver.common.by import By
from selenium.webdriver.firefox.options import Options
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
    driver.find_element(By.ID, "menu_pim_viewMyDetails").click()
    driver.find_element(By.ID, "menu_pim_addWorkExperience").click()
    driver.find_element(By.ID, "experience_employer").send_keys("IBM Company")
    driver.find_element(By.ID, "experience_jobtitle").send_keys("Software Engineer")
    driver.find_element(By.ID, "experience_from_date").send_keys("2020-01-01")
    driver.find_element(By.ID, "experience_to_date").send_keys("2024-12-31")
    driver.find_element(By.ID, "experience_comments").send_keys("Worked on web development projects.")
    driver.find_element(By.ID, "btnWorkExpSave").click()
    print("Work Experience added successfully.")
except NoSuchElementException as e:
    print(f"Element not found: {e}")
finally:
    driver.quit()
