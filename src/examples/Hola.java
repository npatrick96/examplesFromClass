package examples;


import javax.script.*;


public class Hola{
    static ScriptEngineManager factory = new ScriptEngineManager();
    static ScriptEngine engine = factory.getEngineByName("JavaScript");

     public static void main(String []args) throws ScriptException{
        
        if (engine.eval("3==3").toString() == "true") {
        	//System.out.println(engine.eval("6>3"));
        	System.out.println("okoo");
        }
     }
}