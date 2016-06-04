public class Object {
	
	private String name;
	private String type;
	private String value;
	private String operator;
	
	Object(String name,String type,String value){
		this.setName(name);
		this.setType(type);
		this.setValue(value);
	}
	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	public String getValue() {
		return value;
	}
	public void setValue(String value) {
		this.value = value;
	}
	public String getOperator() {
		return operator;
	}
	public void setOperator(String operator) {
		this.operator = operator;
	}
	
	

}
