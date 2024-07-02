from selenium import webdriver
from selenium.webdriver.firefox.options import Options
from selenium.common.exceptions import NoSuchElementException

options = Options()
options.headless = True
driver = webdriver.Firefox(options=options)

try:

    driver.get("http://alchemy.hguy.co/orangehrm")
    actual_title = driver.title
    expected_title = "OrangeHRM"
    if actual_title == expected_title:
        print("Website title verification successful.")
    else:
        print(f"Expected title: '{expected_title}', but got '{actual_title}'.")

except NoSuchElementException as e:
    print(f"Element not found: {e}")

finally:

    driver.quit()
