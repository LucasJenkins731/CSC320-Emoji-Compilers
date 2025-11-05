// This demonstrates the fix for your code generation type issue

public class TypeFixTest {
    
    // Your original enum (already defined in your grammar)
    enum Type {
        INT, FLOAT, STRING, CHAR, ARRAY, UNKNOWN
    }
    
    // Helper method to convert Type enum to Java type string
    // (This is what I added to your generateAssign method)
    String getJavaType(Type type) {
        switch (type) {
            case INT: return "int";
            case FLOAT: return "double";
            case STRING: return "String";
            case CHAR: return "char";
            default: return "double"; // fallback
        }
    }
    
    // Your ORIGINAL generateAssign method (the problem)
    void generateAssignOld(boolean declare, String name, String rhsJavaCode) {
        System.out.println("OLD: " + (declare ? "double " : " ") + name + " = " + rhsJavaCode + ";");
    }
    
    // Your FIXED generateAssign method (the solution)
    void generateAssignNew(boolean declare, String name, String rhsJavaCode, Type type) {
        String javaType = getJavaType(type);
        System.out.println("NEW: " + (declare ? javaType + " " : " ") + name + " = " + rhsJavaCode + ";");
    }
    
    public static void main(String[] args) {
        TypeFixTest test = new TypeFixTest();
        
        System.out.println("=== BEFORE FIX (everything becomes double) ===");
        test.generateAssignOld(true, "x", "5");
        test.generateAssignOld(true, "name", "\"John\"");
        test.generateAssignOld(true, "letter", "'A'");
        test.generateAssignOld(true, "pi", "3.14");
        
        System.out.println("\n=== AFTER FIX (proper types) ===");
        test.generateAssignNew(true, "x", "5", Type.INT);
        test.generateAssignNew(true, "name", "\"John\"", Type.STRING);
        test.generateAssignNew(true, "letter", "'A'", Type.CHAR);
        test.generateAssignNew(true, "pi", "3.14", Type.FLOAT);
    }
}