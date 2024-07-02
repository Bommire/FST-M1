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
    directory_menu_item = driver.find_element(By.ID, "menu_directory_viewDirectory") 
    if directory_menu_item.is_displayed() and directory_menu_item.is_enabled():
        print("Directory menu item is visible and clickable.")
        directory_menu_item.click()
    else:
        print("Directory menu item is not visible or clickable.")
    page_heading = driver.find_element(By.XPATH, "//h1[text()='Search Directory']").text  
    if page_heading == "Search Directory":
        print("Page heading matches 'Search Directory'.")
    else:
        print(f"Page heading '{page_heading}' does not match 'Search Directory'.")

except NoSuchElementException as e:
    print(f"Element not found: {e}")

finally:
    driver.quit()
