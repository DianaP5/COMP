public class Object {
	
	private String name;
	private String type;
	
	Object(String name,String returnName){
		this.setName(name);
		this.setReturnName(returnName);
	}
		public String getReturnName() {
		return type;
	}

	public void setReturnName(String returnName) {
		this.type = returnName;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	

}
