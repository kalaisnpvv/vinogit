Feature: Add, Update and Delete Place in Map API

  @AddPlace
  Scenario Outline: Add Place and Get place using place-id and verify status code and address
    Given "Add" API request sent with body as "<name>" "<language>" "<address>"
    When Resource URL sent for "AddPlaceAPI" using http method as "POST"
    Then Verify the Status code is 200
    And Get "place_id" from the Response Body
    When API request sent with parameter as "place_id"
    When Resource URL sent for "GetPlaceAPI" using http method as "GET"
    Then Verify the Status code is 200
    And Get "address" from the Response Body
    Then Verify "address" and "<address>" were same

    Examples: 
      | name | language | address      |
      | Vino | Tamil    | Ambur, India |
	     
  @UpdatePlace
  Scenario Outline: Update Addess and verify status code and address is updated
    Given "Update" API request sent with body as "place_id" "<address>" "keyUrl"
    When Resource URL sent for "UpdatePlaceAPI" using http method as "PUT"
    Then Verify the Status code is 200
    And Get "msg" from the Response Body
    Then Verify "msg" and "Address successfully updated" were same
    When API request sent with parameter as "place_id"
    When Resource URL sent for "GetPlaceAPI" using http method as "GET"
    Then Verify the Status code is 200
    And Get "address" from the Response Body
    Then Verify "address" and "<address>" were same

    Examples: 
      | name  | language | address        | 
      | Yugan | English  | Chennai, India |
      
  @DeletePlace
  Scenario: Delete Place and Get place using place-id and verify place is not found
    Given "Delete" API request sent with body as "place_id" "No address" "No keyUrl"
    When Resource URL sent for "DeletePlaceAPI" using http method as "DELETE"
    Then Verify the Status code is 200
    And Get "status" from the Response Body
    Then Verify "status" and "OK" were same
    When API request sent with parameter as "place_id"
    When Resource URL sent for "GetPlaceAPI" using http method as "GET"
    Then Verify the Status code is 404
    And Get "msg" from the Response Body
    Then Verify "msg" and "Get operation failed, looks like place_id  doesn't exists" were same