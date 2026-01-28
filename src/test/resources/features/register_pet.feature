Feature: Register Pet

  Scenario: Add a new pet to the store
    Given "Juanito the intern" wants to add a new pet
    When he adds the pet to the store
      | id   | category_id | category_name | name | photo_url                          | tag_id | tag_name | status  |
      | 3235 | 6           | cat           | Lupe | https://example.com/image_lupe.jpg | 6      | cat      | pending |
    Then the pet should be successfully added with id 3235 and the response status code should be 200
