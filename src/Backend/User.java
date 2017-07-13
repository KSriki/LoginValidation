package Backend;



public class User {
	
	private String name;
	private String email;
	
	public User(String n,String e){
		this.name=n;
		this.email=e;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
	
	//Need to check against database
	
	public boolean validateUser(String name, String email, String encPass){
		//probably want to encrypt and compare than compare literal raw input
		
		return validateUser(new User(name,email)); //&& checkPassword encPass against database ?
		
		
	}
	
	public boolean validateUser(User otherUser){
		//probably want to encrypt and compare than compare literal raw input
	
		return otherUser.equals(this);
		
		
	}
	
	@Override
	public boolean equals(Object obj) {
		// TODO Auto-generated method stub
		if(obj instanceof User){
			return this.email.equals(((User) obj).getEmail()) && this.name.equals(((User) obj).getName());
		}
		else{
			return false;
		}
	}
	

}
