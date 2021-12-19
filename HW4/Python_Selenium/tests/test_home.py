import pytest
from selenium import webdriver
from page_objects.home_page import home_page
from page_objects.iade_degisim import iade_degisim


class TestHome():
    @classmethod
    @pytest.fixture()
    def setup_method(self, method):
        self.driver = webdriver.Chrome(executable_path="/usr/local/bin/chromedriver.exe")
        self.driver.implicitly_wait(8)

    def teardown_method(self, method):
        self.driver.quit()

    def test_ticket_search(self):
        self.driver.get("https://obilet.com/")
        self.driver.maximize_window()
        home = home_page(self.driver)
        home.test_bilet_arama()

    def test_cancel_change_search(self):
        self.driver.get("https://obilet.com/")
        cancel_change= iade_degisim(self.driver)
        cancel_change.test_iade_iptal()

