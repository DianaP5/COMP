import java.util.ArrayList;


public class Object {
	
	private String name;
	private String type;
	private String value;
	private String operator;
	private String size;
	private ArrayList<String> array;
	
	Object(String name,String type,String value){
		this.setName(name);
		this.setType(type);
		this.setValue(value);
		this.setOperator("null");
		this.setSize("null");
		this.setArray(new ArrayList<String>());
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
			array.add(value);
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
		
		this.array=new ArrayList<String>(Integer.parseInt(size));
	}
	
	public ArrayList<String> getArray() {
		return array;
	}
	public void setArray(ArrayList<String> arrayList) {
		this.array = arrayList;
	}
	
	public void setIndexValue(String index,String value){
		int i=Integer.parseInt(index);
		this.array.set(i,value);
	}
	

}
