package resources;

import pojo.InviteMember;
import pojo.Organization;

public class TestData {

	 public Organization createOrganization(String displayName, String desc, String name, String website)
	 { System.out.println("organization");
		 Organization org= new Organization();
	     org.setDisplayName(displayName);
	     org.setDesc(desc);
	     org.setName(name);
	     org.setWebsite(website);
		 return org;
		 
	 }

	public InviteMember inviteMemeber(String fullName) {
		InviteMember invite= new InviteMember();
		invite.setFullName(fullName);
		return invite;
	}


}
