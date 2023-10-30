import time
import pytest
from selenium import webdriver
from selenium.webdriver.common.by import By
from selenium.webdriver.common.keys import Keys
from selenium.webdriver.support.ui import WebDriverWait
from selenium.webdriver.support import expected_conditions as EC

driver =webdriver.Edge()
driver.implicitly_wait(10)
browser = "https://www.makemytrip.com/"
driver.get(browser)
driver.maximize_window()
# driver.quit()
time.sleep(5)
driver.refresh()
time.sleep(5)
driver.find_element(By.XPATH,"/html/body/div/div[2]/div/div/a/i").click()
# Click on Flights
flights_button = driver.find_element(By.XPATH, "//*[@id='SW']/div[1]/div[2]/div/div/nav/ul/li[1]/div/a")
flights_button.click()

# Select ROUND TRIP
round_trip_button = driver.find_element(By.XPATH, '//*[@id="root"]/div/div[2]/div/div/div/div[1]/ul/li[2]')
round_trip_button.click()

# Enter FROM and TO locations
driver.find_element(By.ID, 'fromCity').click()
driver.send_keys('HYD')
time.sleep(2)
driver.find_element(By.XPATH,"*[@id='react-autowhatever-1-section-0-item-0']/div/div[1]").click()
time.sleep(2)
#*[@id="react-autowhatever-1-section-0-item-0"]/div/div[1]
driver.find_element(By.ID, 'toCity').click()
driver.send_keys('MAA')
time.sleep(1)
to_location.send_keys(Keys.ENTER)
 # Select departure and return dates (you'll need to replace with the actual date selection logic)
departure_date = driver.find_element(By.ID, 'departure')
departure_date.send_keys('2023-09-01')

return_date = driver.find_element(By.ID, 'return')
return_date.send_keys('2023-09-10')

    # Click on Search Button
search_button = driver.find_element(By.ID, 'search_button')
search_button.click()

    # Wait for search page to load and verify
WebDriverWait(driver, 10).until(
    EC.presence_of_element_located((By.XPATH, "//h1[contains(text(),'Search Result')]"))
    )
assert "Search Result" in search_results_page.text

if __name__ == "__main__":
     pytest.main()