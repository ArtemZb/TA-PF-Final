Feature: Social Apps References
  As a user
  I want to see Social Apps references of the shop
  So that I can view and purchase products in the most convenient way

  Scenario Outline: Check Social Apps
    Given User opens '<sitePage>' page
    And User checks the footer visibility
    When User clicks on a '<socialApp>'
    Then User checks that they are redirected to the '<socialAppSite>'

    Examples:
      | sitePage                    | socialApp | socialAppSite                            |
      | https://www.asos.com/       | instagram | https://www.instagram.com                |
      | https://www.asos.com/women/ | facebook  | https://www.facebook.com/ASOS/           |
      | https://www.asos.com/women/ | snapchat  | https://www.snapchat.com/add/asosfashion |