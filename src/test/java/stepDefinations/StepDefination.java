package stepDefinations;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import static org.junit.Assert.*;

import java.io.IOException;

import static io.restassured.RestAssured.*;
import resources.APIResources;
import resources.TestData;
import resources.Utilities;

public class StepDefination extends Utilities {
	
        static RequestSpecification req;
        Response response;
        TestData data= new TestData();
        static String organizationId;
        static String boardId;
        static String memberId;
        static String membershipId;
	    
	@Given("organization Details with {string} {string} {string} {string}")
	public void organization_details_with(String displayName, String desc, String name, String website) throws IOException {
		System.out.println("hi");
		req= given().spec(requestSpecification()).queryParam("displayName", displayName).queryParam("desc", desc).queryParam("name", name)
				.queryParam("website", website);
	}
	@When("u user calls the {string} with {string} http request")
	public void u_user_calls_the_with_http_request(String resource, String method) {
		APIResources resourceAPI= APIResources.valueOf(resource);
		if(method.equalsIgnoreCase("POST"))
		{
			response=req.when().post(resourceAPI.getResource());
		}
		else if(method.equalsIgnoreCase("GET"))
		{
			response=req.when().get(resourceAPI.getResource());
		}
		else if(method.equalsIgnoreCase("PUT"))
		{
			response= req.when().put(resourceAPI.getResource());
		}
		else if(method.equalsIgnoreCase("DELETE"))
		{
			response= req.when().delete(resourceAPI.getResource());
	    }
		
	}

	@Then("validate user got with response success code {int}")
	public void validate_user_got_with_response_success_code(Integer int1) {
		assertEquals(response.getStatusCode(), 200);
	}

	@Then("Validate organization id is created")
	public void validate_organization_id_is_created() {
		organizationId= getorganizationId(response,"id");
		System.out.println("organization id"+organizationId);
	}
	@Given("get the  created organization details")
	public void get_the_created_organization_details() throws IOException {
		req= given().spec(requestSpecification()).pathParam("organizationId", organizationId);
	
     	}
	@Given("g update the organization with {string} {string} {string} {string}")
	public void g_update_the_organization_with(String displayName, String desc, String name, String website) throws IOException {
		req= given().spec(requestSpecification()).queryParam("displayName", displayName).queryParam("desc", desc).queryParam("name", name)
				.queryParam("website", website).pathParam("organizationId", organizationId);
	}
	@Given("delete the organization details")
	public void delete_the_organization_details() throws IOException {
		req= given().spec(requestSpecification()).pathParam("organizationId", organizationId);

	}
	@Then("validate user got with response code {int}")
	public void validate_user_got_with_response_code(Integer int1) {
	    assertEquals(response.getStatusCode(), 400);
	}
	@Then("Validate error message is displayed correctly")
	public void validate_error_message_is_displayed_correctly() {
		String expected_message=getMessage(response,"message");
		String actual_message="Display Name must be at least 1 character";
	    assertEquals(expected_message,actual_message);

	}@Given("Board Details with {string} {string} {string}")
	public void board_details_with(String name, String desc, String idOrganization) throws IOException {
		req= given().spec(requestSpecification()).queryParam("name", name).queryParam("desc",desc).queryParam("idOrganization",idOrganization);

	}
	@Then("Validate board id is created")
	public void validate_board_id_is_created() {
		boardId= getBoardId(response, "id");
		System.out.println("boardId"+boardId);
	}
	@Given("get the created board details")
	public void get_the_created_board_details() throws IOException {
		req= given().spec(requestSpecification()).pathParam("boardId", boardId);

	}
	@Given("update Board Details with {string} {string} {string}")
	public void update_board_details_with(String name, String desc, String idOrganization) throws IOException {
		req= given().spec(requestSpecification()).pathParam("boardId", boardId).queryParam("name", name).queryParam("desc", desc).queryParam("idOrganization", idOrganization);

	}
	@Given("delete  the created board details")
	public void delete_the_created_board_details() throws IOException {
		req= given().spec(requestSpecification()).pathParam("boardId", boardId);

	}
	@Given("Get the mebrship for created board")
	public void get_the_mebrship_for_created_board() throws IOException {
		req= given().spec(requestSpecification()).pathParam("boardId", boardId);

	}
	@Given("get the field on the created board")
	public void get_the_field_on_the_created_board() throws IOException {
		req= given().spec(requestSpecification()).pathParam("boardId", boardId).pathParam("name", "name");

    	}
	@Given("list details on created board with {string} {string}")
	public void list_details_on_created_board_with(String name, String pos) throws IOException {
		req= given().spec(requestSpecification()).pathParam("boardId", boardId).queryParam("name", name).queryParam("pos", pos);

	
	}
	@Given("check list Details on created board with {string}")
	public void check_list_details_on_created_board_with(String name) throws IOException {
		req= given().spec(requestSpecification()).pathParam("boardId", boardId).queryParam("name", name);

	    
	}
	
	@Given("add member  Details on created board with {string} {string}")
	public void add_member_details_on_created_board_with(String idMember, String type) throws IOException {
		req= given().spec(requestSpecification()).pathParam("boardId", boardId).pathParam("idMember", idMember)
				.queryParam("type",type);
	}

	@Then("Validate member id is created")
	public void validate_member_id_is_created() {
		memberId= getMemeberId(response,"id");
		System.out.println("member id"+memberId);
		membershipId=getMemberShipId(response,"idMember");
		System.out.println("membershipId"+membershipId);
	}
	
	@Given("get member  Details on created board")
	public void get_member_details_on_created_board() throws IOException {
		req= given().spec(requestSpecification()).pathParam("boardId", boardId);
				
	}
	@Given("Remove the  added  member from created board with {string}")
	public void remove_the_added_member_from_created_board_with(String idMember) throws IOException {
		req= given().spec(requestSpecification()).pathParam("boardId", boardId).pathParam("idMember", idMember);
	}
	@Given("update  the  membership of  member from created board with {string}")
	public void update_the_membership_of_member_from_created_board_with(String type) throws IOException {
		req= given().spec(requestSpecification()).pathParam("boardId", boardId).pathParam("idMembership", membershipId)
				.queryParam("type", type);

	}
	
	@Given("Invite member Details for the created board  {string} {string} {string}")
	public void invite_member_details_for_the_created_board(String email, String type, String fullName) throws IOException {
		req= given().spec(requestSpecification()).pathParam("boardId", boardId).queryParam("email",email).queryParam("type", type)
				.body(data.inviteMemeber(fullName));
	}
	@Given("calendar key details for the created board")
	public void calendar_key_details_for_the_created_board() throws IOException {
		req= given().spec(requestSpecification()).pathParam("boardId", boardId);
				
	}

	@Given("email key details for the created board")
	public void email_key_details_for_the_created_board() throws IOException {
		req= given().spec(requestSpecification()).pathParam("boardId", boardId);

	}
	@Given("tag  details for the created board")
	public void tag_details_for_the_created_board() throws IOException {
		req= given().spec(requestSpecification()).pathParam("boardId", boardId);

	}
	@Given("board as viewed  details for the created board")
	public void board_as_viewed_details_for_the_created_board() throws IOException {
		req= given().spec(requestSpecification()).pathParam("boardId", boardId);

	}
	@Given("lablel   details for the created board with {string} {string}")
	public void lablel_details_for_the_created_board_with(String name, String color) throws IOException {
		req= given().spec(requestSpecification()).pathParam("boardId", boardId).queryParam("name", name).queryParam("color", color);

	}



}
