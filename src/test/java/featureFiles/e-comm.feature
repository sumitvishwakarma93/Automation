Feature: Testing of e-commerce website
  I want to use this template for my feature file
  
  Background:
    Given User is on saucedemo page "https://www.saucedemo.com/"

@test
Scenario: Login to application and order an item
    Given Login with username <username> and password <password>
    When Select the product and add it to cart
    Then Go to cart and order that product
    |Mia|
    |Khalifa|
    |356021|

		Examples:
		| username  								| password 		|
    |standard_user 					  	|secret_sauce |
		|locked_out_user						|secret_sauce	|	 
		|problem_user								|secret_sauce	| 
		|performance_glitch_user		|secret_sauce	| 
		|error_user									|secret_sauce |
		|visual_user								|secret_sauce |

@standard_user_login      
Scenario Outline: Login to application and order an item
    Given Login with username <username> and password <password>
    When Select the product and add it to cart
    Then Go to cart and order that product
    |Mia|
    |Khalifa|
    |356021|

    Examples: 
      | username  								| password 		 |
      | standard_user 						| secret_sauce |


@Locked_user_login      
Scenario Outline: Login to application and order an item
    Given Login with username <username> and password <password>
    When Select the product and add it to cart
    Then Go to cart and order that product
    |Mia|
    |Khalifa|
    |356021|

    Examples: 
      | username  								| password 		 |
      | locked_out_user					 	| secret_sauce |

@problem_user_login      
Scenario Outline: Login to application and order an item
    Given Login with username <username> and password <password>
    When Select the product and add it to cart
    Then Go to cart and order that product
    |Mia|
    |Khalifa|
    |356021|

    Examples: 
      | username  		| password 		 |
      | problem_user	| secret_sauce |

@performance_glitch_user_login      
Scenario Outline: Login to application and order an item
    Given Login with username <username> and password <password>
    When Select the product and add it to cart
    Then Go to cart and order that product
    |Mia|
    |Khalifa|
    |356021|

    Examples: 
      | username  								| password 		 |
			| performance_glitch_user 	| secret_sauce |

@error_user_login      
Scenario Outline: Login to application and order an item
    Given Login with username <username> and password <password>
    When Select the product and add it to cart
    Then Go to cart and order that product
    |Mia|
    |Khalifa|
    |356021|

    Examples: 
      | username  	| password 		 |
			| error_user 	| secret_sauce |
						      
@Visual_user_login      
Scenario Outline: Login to application and order an item
    Given Login with username <username> and password <password>
    When Select the product and add it to cart
    Then Go to cart and order that product
    |Mia|
    |Khalifa|
    |356021|

    Examples: 
      | username  								| password 		 |
 			| visual_user 							| secret_sauce |
 			

@check_links      
Scenario Outline: Login to application and check all the items links
    Given Login with username <username> and password <password>
    When Select all the links on that page
    Then Click all links one by one

    Examples: 
      | username  								| password 		 |
      | standard_user 						| secret_sauce | 			
 			
 			
 			
 			
 			
 			