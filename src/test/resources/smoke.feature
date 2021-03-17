Feature: Smoke
  As a user
  I want to test all main site functional
  So that I can be sure that site works correctly

  Scenario: Check Search Products by Keyword
    Given User opens 'https://www.asos.com/' page
    And User checks search field visibility
    And User checks 'Search' button is disabled by default
    When User makes search by keyword 'shoes'
    And User clicks search button
    Then User checks that search result is not empty


  Scenario Outline: Check add product to wishlist
    Given User opens '<homePage>' page
    And User checks search field visibility
    And User checks 'Search' button is disabled by default
    When User makes search by keyword '<keyword>'
    And User clicks search button
    And User checks that search result is not empty
    And User clicks 'Wishlist' icon on '<amountOfProducts>'
    And User clicks on the Wish List Page button
    Then User checks that amount of products in wish list are '<amountOfProducts>'

    Examples:
      | homePage              | keyword | amountOfProducts |
      | https://www.asos.com/ | shoes   | 2                |


  Scenario Outline: Check Sort Product list
    Given User opens '<homePage>' page
    And User checks search field visibility
    And User checks 'Search' button is disabled by default
    When User makes search by keyword '<keyword>'
    And User clicks search button
    And User checks that search result is not empty
    Then User clicks on '<sortOrder>' from the 'Sort' drop-down
    And User checks that products are sorted correctly according to '<sortOrder>'

    Examples:
      | homePage              | keyword | sortOrder |
      | https://www.asos.com/ | shoes   | priceASC  |
      | https://www.asos.com/ | shoes   | priceDESC |


  Scenario Outline: Check Product Checkout
    Given User opens '<homePage>' page
    And User checks search field visibility
    When User makes search by keyword '<keyword>'
    And User clicks search button
    And User checks that search result is not empty
    And User clicks on Product item
    And User clicks on 'Add to bag' button
    And User checks that add to cart popup visible
    And User checks 'View Bag' button visibility
    And User checks 'Checkout' button visibility
    And User clicks 'View Bag' button
    And User checks the total price visibility
    And User clicks 'Checkout' button
    Then User checks email and password fields visibility on the login form

    Examples:
      | homePage              | keyword   |
      | https://www.asos.com/ | bracelets |


  Scenario Outline: Check Add Product to Cart
    Given User opens '<homePage>' page
    And User checks search field visibility
    When User makes search by keyword '<keyword>'
    And User clicks search button
    And User checks that search result is not empty
    And User clicks on Product item
    And User clicks on 'Add to bag' button
    Then User checks that amount of products in cart is '<amountOfProducts>'

    Examples:
      | homePage              | keyword   | amountOfProducts |
      | https://www.asos.com/ | bracelets | 1                |

  Scenario Outline: Download Mobile Applications
    Given User opens '<homePage>' page
    And User checks the footer visibility
    When User clicks on 'Mobile and ASOS Apps' button
    And User checks the 'DOWNLOAD THE ASOS APP' page is displayed
    Then User clicks on the '<appOption>'
    And User checks the '<webSite>' for download is displayed

    Examples:
      | homePage              | appOption | webSite                                                    |
      | https://www.asos.com/ | android   | https://play.google.com/store/apps/details?id=com.asos.app |
      | https://www.asos.com/ | iPhone    | https://apps.apple.com/gb/app/asos/id457876088             |