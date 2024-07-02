from selenium import webdriver
from selenium.webdriver.firefox.options import Options
from selenium.common.exceptions import NoSuchElementException
options = Options()
options.headless = True
driver = webdriver.Firefox(options=options)

try:
    driver.get("http://alchemy.hguy.co/orangehrm")
    header_image = driver.find_element_by_xpath("//div[@id='divLogo']/img")
    header_image_url = header_image.get_attribute("src")
    print("URL of the header image:", header_image_url)

except NoSuchElementException as e:
    print(f"Element not found: {e}")

finally:
    driver.quit()
