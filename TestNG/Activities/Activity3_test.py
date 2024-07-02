from selenium import webdriver
from selenium.webdriver.common.by import By
from selenium.webdriver.common.keys import Keys
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
    welcome_message = driver.find_element(By.ID, "welcome").text
    if "Welcome" in welcome_message:
        print("Login successful. Homepage verified.")

    else:
        print("Login unsuccessful. Homepage not verified.")

except NoSuchElementException as e:
    print(f"Element not found: {e}")

finally:
    driver.quit()
