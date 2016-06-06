import java.util.ArrayList;


public class Object {
	
	private String name;
	private String type;
	private String value;
	private String operator;
	private String size;
	private ArrayList<Integer> array;
	
	Object(String name,String type,String value){
		this.setName(name);
		this.setType(type);
		this.setValue(value);
		this.setOperator("null");
		this.setSize("null");
		this.setArray(new ArrayList<Integer>());
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
		
		if (this.value.equals("null") || this.type.equals("scalar"))
			return;
		
		for (int i = 0; i < Integer.parseInt(this.size); i++)
			array.add(Integer.parseInt(value));
	}
	
	public String getOperator() {
		return operator;
	}
	public void setOperator(String operator) {
		this.operator = operator;
	}
	public String getSize() {
		return size;
	}
	public void setSize(String size) {
		this.size = size;
		
		if (this.size.equals("null"))
			return;
		
		if (Integer.parseInt(size) <= 0){
			System.out.println("SIZE <= 0 ARRAY");
			return;
		}
		
		this.array=new ArrayList<Integer>(Integer.parseInt(size));
	}
	
	public ArrayList<Integer> getArray() {
		return array;
	}
	public void setArray(ArrayList<Integer> arrayList) {
		this.array = arrayList;
	}
	
	

}
