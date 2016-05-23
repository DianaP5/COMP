import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;


public class JVCgenerator {
	
	private String fileName;
	private PrintWriter writer;
	
	JVCgenerator(String fileName) throws FileNotFoundException, UnsupportedEncodingException{
		this.fileName=fileName;
		
		this.writer = new PrintWriter(fileName+".j", "UTF-8");
	}
	
	void addModule(String moduleName){
		writer.println(".class public "+moduleName);
		writer.println(".super java/lang/Object");
	}
	
	void addVar(String varName,String varValue){
		writer.println(".field static "+varName+"I = "+varValue);
	}
	
	void addFunction(String funcName,String stack,String locals){
		writer.println(".method public static "+funcName+"([Ljava/lang/String;)V");
		writer.println(".limit stack "+stack);
		writer.println(".limit locals "+locals);
	}
	
	void closeWriter(){
		
		writer.println("return");
		writer.println(".end method");
		
		writer.close();
	}
	
}
