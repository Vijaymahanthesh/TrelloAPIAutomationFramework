Feature: Validate organization Module
@organization
Scenario Outline: Validate organization is created
Given organization Details with "<displayName>" "<desc>" "<name>" "<website>"
When u user calls the "createOrganizationAPI" with "POST" http request
Then validate user got with response success code 200
And Validate organization id is created
Examples:
          |displayName        |desc                   |name   |website       |
          |ey                 |ey is  organization     |eyeeee     |www.trello.com|
          
@organization
Scenario Outline: Validate organization without displayname
Given organization Details with "<displayName>" "<desc>" "<name>" "<website>"
When u user calls the "createOrganizationAPI" with "POST" http request
Then validate user got with response code 400
And Validate error message is displayed correctly
Examples:
          |displayName|desc                   |name   |website       |
          |           |ey is  organization|eyeeee|www.trello.com    |
@organization
Scenario Outline: Validate created organization is updated
Given g update the organization with "<displayName>" "<desc>" "<name>" "<website>"
When u user calls the "updateOrganizationAPI" with "PUT" http request
Then validate user got with response success code 200
     
       Examples:
          |displayName        |desc                 |name   |website     |
          | rsaaa             |jira is  organization |rsaaa    |www.jira1.com|  
                   
@organization
Scenario: Validate created organization is displayed
Given get the  created organization details
When u user calls the "getOrganizationAPI" with "GET" http request
Then validate user got with response success code 200

                   
@organization
Scenario: Validate  organization is deleted
Given delete the organization details
When u user calls the "deleteOrganizationAPI" with "DELETE" http request
Then validate user got with response success code 200


@createBoard  @Regression
Scenario Outline: Validate Board is created
Given Board Details with "<name>" "<desc>" "<idOrganization>"
When u user calls the "createBoardAPI" with "POST" http request
Then validate user got with response success code 200
And Validate board id is created
 Examples:
          |name         |desc                   |idOrganization|
          |cricket Board|Cricket is good to play|jira305|
 

#@board
@createBoard
Scenario Outline: Validate Board is updated
Given  update Board Details with "<name>" "<desc>" "<idOrganization>"
When u user calls the "updateBoardAPI" with "PUT" http request
Then validate user got with response success code 200
And Validate board id is created
 Examples:
          |name               |desc                   |idOrganization|
          |cricket Board India|Cricket is good to play|user97528145|
#@getBoard @Regression
@createBoard
Scenario: Validate created  board details are retrieved
Given get the created board details 
When u user calls the "getBoardAPI" with "GET" http request
Then validate user got with response success code 200

 #@board
Scenario: Validate Board is deleted successfully
Given delete  the created board details 
When u user calls the "deleteBoardAPI" with "DELETE" http request
Then validate user got with response success code 200
         
@createBoard
Scenario: Validate membership is created for board
Given Get the mebrship for created board
When u user calls the "getMembershipBoardAPI" with "GET" http request
Then validate user got with response success code 200

@createBoard
Scenario: Validate Get the field on the created board
Given get the field on the created board
When u user calls the "getFieldOnBoardAPI" with "GET" http request
Then validate user got with response success code 200

#@createListsonBoard
@createBoard
Scenario Outline: Validate create a list on the created board
Given list details on created board with "<name>" "<pos>"
When u user calls the "createListsOnBoardAPI" with "POST" http request
Then validate user got with response success code 200
        
 Examples:
           |name       |pos|
           |in progress|4  |

#@createListsonBoard
@createBoard
Scenario Outline: Validate Create List without name on the created board
Given list details on created board with "<name>" "<pos>"
When u user calls the "createListsOnBoardAPI" with "POST" http request
Then validate user got with response code 400
        
 Examples:
           |name       |pos|
           |           |4  |
          
#@createCheckList
Scenario Outline: Validate create a checklist on the created board
Given check list Details on created board with "<name>"
When u user calls the "createCheckListOnBoardAPI" with "POST" http request
Then validate user got with response success code 200
And Validate checklist id is created
        
 Examples:
           |name|
           |work|  
           
#@addmembertoBoard
@createBoard
Scenario Outline: Validate add member to the created board
Given add member  Details on created board with "<idMember>" "<type>"
When u user calls the "addMemberOnBoardAPI" with "PUT" http request
Then validate user got with response success code 200
And Validate member id is created
        
 Examples:
           |idMember       |type  |
           |vijaymahanthesh|normal|  
                      
#@addmembertoBoard
@createBoard
Scenario Outline: Validate add member to the created board without idmember and type
Given add member  Details on created board with "<idMember>" "<type>"
When u user calls the "addMemberOnBoardAPI" with "PUT" http request
Then validate user got with response code 400        
 Examples:
           |idMember|type  |
           |||   

#@addmembertoBoard
@createBoard
Scenario: Validate get the  members on created board
Given get member  Details on created board
When u user calls the "getMembersOnBoardAPI" with "GET" http request
Then validate user got with response success code 200
           
#@addmembertoBoard
Scenario Outline: Validate remove the added member on the created board
Given Remove the  added  member from created board with "<idMember>"
When u user calls the "removeMemberOnBoardAPI" with "DELETE" http request
Then validate user got with response success code 200        
 Examples:
           |idMember       |
           |vijaymahanthesh|

@addmembertoBoard
Scenario Outline: Validate update the membership of member on  the created board
Given update  the  membership of  member from created board with "<type>"
When u user calls the "updatemembershipofmemberOnBoardAPI" with "PUT" http request
Then validate user got with response success code 200        
 Examples:
           |type       |
           |normal     |   

#@Invite
@createBoard
Scenario Outline: Validate Invite the member to the created board
Given Invite member Details for the created board  "<email>" "<type>" "<fullName>"
When u user calls the "InviteMebersforBoardAPI" with "PUT" http request
Then validate user got with response success code 200        
 Examples:
           |email                    |type      |fullName|
           |mahanthesh.mlk@gmail.com |normal    |Vijay   | 

#@Invite
@createBoard
Scenario Outline: Validate Invite the member to the created board with invalid email id
Given Invite member Details for the created board  "<email>" "<type>" "<fullName>"
When u user calls the "InviteMebersforBoardAPI" with "PUT" http request
Then validate user got with response code 400
 Examples:
           |email                    |type      |fullName|
           |mahanthesh.mlk |normal    |Vijay   |  
           
#@Invite
@createBoard
Scenario Outline: Validate Invite the member to the created board without email
Given Invite member Details for the created board  "<email>" "<type>" "<fullName>"
When u user calls the "InviteMebersforBoardAPI" with "PUT" http request
Then validate user got with response code 400
 Examples:
           |email|type      |fullName|
           |     |          |        |                                                 
                            
#@CreateCalendarKey
Scenario: Validate calendar key is generated for created board
Given calendar key details for the created board  
When u user calls the "generatecalendarKeyonBoardAPI" with "POST" http request
Then validate user got with response success code 200

#@CreatemailKey
Scenario: Validate email key is generated for created board
Given email key details for the created board  
When u user calls the "generateemailrKeyonBoardAPI" with "POST" http request
Then validate user got with response success code 200  

#@CreateTag
Scenario: Validate tag is generated for created board
Given tag  details for the created board  
When u user calls the "createTagKonBoardAPI" with "POST" http request
Then validate user got with response success code 200

#@boardasViewed
Scenario: Validate created board is viewed
Given board as viewed  details for the created board  
When u user calls the "boardAsViewedonBoardAPI" with "POST" http request
Then validate user got with response success code 200 

#@createlabel
Scenario Outline: Validate  label can be created on  created board
Given lablel   details for the created board with "<name>" "<color>"  
When u user calls the "createlabelonBoardAPI" with "POST" http request
Then validate user got with response success code 200            

 Examples:
          |name |color|
          |label|blue|
