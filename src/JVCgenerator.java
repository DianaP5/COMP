import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;


public class JVCgenerator {
	
	private String fileName;
	private PrintWriter writer;
	
	private File f1;
	private int numLoops = 0, maxLoops = 0;
	
	private SimpleNode node;
	private String moduleName;
	
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
	
	void loopwhile(SimpleNode n3, int j, FileOutputStream fich, int tmp) throws IOException {


		numLoops += tmp;
		
		if(numLoops > maxLoops)
			maxLoops=numLoops;
		
		
		SimpleNode ExprTest = (SimpleNode)n3.jjtGetChild(0).jjtGetChild(1);
		SimpleNode Oper = (SimpleNode)ExprTest.jjtGetChild(1);

		String oper = "";
		
		if(Oper.operation.toString().equals("=="))
			oper+="\tif_icmpne loop_end" +  numLoops + "\n";
		else if(Oper.operation.toString().equals(">="))
			oper+="\tif_icmplt loop_end" +  numLoops + "\n";
		else if(Oper.operation.toString().equals(">"))
			oper+="\tif_icmple loop_end" +  numLoops + "\n";
		else if(Oper.operation.toString().equals("<="))
			oper+="\tif_icmpgt loop_end" +  numLoops + "\n";
		else if(Oper.operation.toString().equals("<"))
			oper+="\tif_icmpge loop_end" +  numLoops + "\n";
		else if(Oper.operation.toString().equals("!="))
			oper+="\tif_icmpeq loop_end" +  numLoops + "\n";		
		fich.write(oper.getBytes());
		
		
		
		fich.write(("\tgoto loop"+ numLoops +"\nloop_end" + numLoops +":\n").getBytes());
		
		
		
	}
	
	void closeWriter(){
		
		writer.println("return");
		writer.println(".end method");
		
		writer.close();
	}
	
}
