Feature: Contact US
  Scenario Outline: Validate Inquiry via contactUS
    Given User navigate to contact us page
    When user has to write "<fullName>" , "<email>", and "<enquiry>" in their fields
    Then I should validate that user send us his enquiry
    Examples:
      | fullName     | email            | enquiry                         |
      | Eslam Fawzy  | test@test.com    | Hello Eslam , this is for test  |
      | Anca Fologea | Anca@Fologea.com | Hello Anca , this is for test   |
      | Ismael Sobhy | Ismail@Sobhy.com | Hello Ismail , this is for test |
      | Eslam Said   | Islam@said.com   | Hello Said , this is for test   |