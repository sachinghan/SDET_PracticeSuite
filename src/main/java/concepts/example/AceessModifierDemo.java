package concepts.example;

// we are talking about access    within class,  within package,  outside package by subclass,  outside package
// private -                       yes     ,      no          ,       no,                       no
// default-                        yes,           yes         ,      no,                        no
//protected-                       yes,           yes         ,      yes,                       no
//public-                          yes ,          yes         ,      yes,                       yes

    class AccessModifiers {

    public static class Parent {
        public String publicField = "Public";
        protected String protectedField = "protected";
        String defaultField = "default";
        public String privateField = "private";
        public void displayAll() {
            System.out.println("Public " + publicField);
            System.out.println("Protected " + protectedField);
            System.out.println("Default " + defaultField);
            System.out.println("Private " + privateField);
        }
    }
}


public class AceessModifierDemo{

    public static void main(String[] args){
        AccessModifiers.Parent obj = new AccessModifiers.Parent();
        System.out.println(obj.publicField);
        System.out.println(obj.protectedField);
        System.out.println(obj.defaultField);
    //    System.out.println(obj.privateField); // compile error
        obj.displayAll();
    }
}
