Feature: Web-site home page
       As a customer,
       I want to open home page 
       so that I can navigate through all the menus in the web-site
 
Scenario: Menu Items are Displayed
       Given the user is on Home page
       When he expects the following menu item: "Why FieldAware, Product, Industries, Integration, Resources, Customers, Company, Get a Demo"
       Then ensure the Menu Items are Displayed
       And the menu order is as specified
 
