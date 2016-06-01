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
	
	void addVarInFunc(String varName,String varValue, String varStack){
		writer.println("iconst_"+varValue);
		writer.println("istore_"+varStack);
	}
	
	void addFunctionSemArgs(String funcName,String stack,String locals){
		writer.println(".method public static "+funcName+"([Ljava/lang/String;)V");
		writer.println(".limit stack "+stack);
		writer.println(".limit locals "+locals);
	}
	
	void addFunctionComArgs(String funcName,String stack, String locals, int NumArgs){
		writer.println(".method public static "+funcName+"([" + NumArgs + ")V");
		writer.println(".limit stack "+stack);
		writer.println(".limit locals "+locals);
	}
	
	void addArrayLocal(int varValue){
		writer.println("bipush" + varValue);
		writer.println("new array int");
		writer.println("astore_1");
	}
	
	void addArrayAtributeModule(String moduleName, String variable, int value){
		writer.println("bipush " + value);
		writer.println("new array int");
		writer.println("putstatic " + moduleName + "/ " + variable + " [I");
	}
	
	void callIO(){
		
		writer.println("invokestatic io/print(Ljava/lang/String;I)V");
		
	}
	
	void loops(int NumArgs, String varStack, String operator){
		writer.println("loop:");

		for(int i = 0; i<= NumArgs; i++){
			writer.println("iload_" + varStack);
		}
		
		if(operator == "<"){
			writer.println("if_icmpge loop_end");
		}
		
		//TODO FAZER PARA TODOS OS OPERADORES
		
	}
	
	void closeWriter(){
		
		writer.println("return");
		writer.println(".end method");
		
		writer.close();
	}
	
}
