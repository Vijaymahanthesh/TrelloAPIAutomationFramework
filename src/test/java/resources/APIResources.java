package resources;

public enum APIResources {
	createOrganizationAPI("/1/organizations"),
	getOrganizationAPI("/1/organizations/{organizationId}"),
	updateOrganizationAPI("/1/organizations/{organizationId}"),
	deleteOrganizationAPI("/1/organizations/{organizationId}"),
	createBoardAPI("/1/boards/"),
	getBoardAPI("/1/boards/{boardId}"),
	updateBoardAPI("/1/boards/{boardId}"),
	deleteBoardAPI("/1/boards/{boardId}"),
	getMembershipBoardAPI("/1/boards/{boardId}/memberships"),
	getFieldOnBoardAPI("/1/boards/{boardId}/{name}"),
	createListsOnBoardAPI("/1/boards/{boardId}/lists"),
	createCheckListOnBoardAPI("/1/boards/{boardId}/checklists"),
	addMemberOnBoardAPI("1/boards/{boardId}/members/{idMember}"),
	getMembersOnBoardAPI("/1/boards/{boardId}/members"),
	removeMemberOnBoardAPI("/1/boards/{boardId}/members/{idMember}"),
	updatemembershipofmemberOnBoardAPI("1/boards/{boardId}/memberships/{idMembership}"),
	InviteMebersforBoardAPI("1/boards/{boardId}/members"),
	generatecalendarKeyonBoardAPI("/1/boards/{boardId}/calendarKey/generate"),
	generateemailrKeyonBoardAPI("/1/boards/{boardId}/emailKey/generate"),
	createTagKonBoardAPI("/1/boards/{boardId}/idTags"),
	boardAsViewedonBoardAPI("/1/boards/{boardId}/markedAsViewed"),
	createlabelonBoardAPI("/1/boards/{boardId}/labels");






















	private String resource;

	APIResources(String resource) {
	this.resource = resource;

	}

	public String getResource() {
		return resource;
	}

}
