package concepts.example;
/*
 * A constructor is a special method used to initialize objects
 * -It has same name as the class
 * -It has NO return type(not even void)
 * Key concepts -
 * a) Constructor overloading : Multiple constructors with different params
 * b) Constructor Chaining : Calling one constructor from another using 'this()'.
 *   This follows the "DRY" (Don't repeat yourself)principle
 * c) super() : calls the parent class constructor. Must be the first line.
 *
 * REAL-WORLD ANALOGY;
 * Think of ordering a pizza - option 1) (Default) - Standard Cheese Pizza
 *                             option 2) (param 1) - cheese + pepperoni
 *                             option 3) (param 2) - cheese + pepperoni +Extra cheese
 * option 3 calls option 2 which calls option 1, This is constructor chaining
 *
 * Interview Questions -
 * - Can a construtor be private ? Yes for a singleton pattern
 * - Can a constructor be final, static, or abstract ? NO
 * - What happens if you don't write a constructor ? (Java adds a default no arg one)
 */
public class ConstructorsLesson {
    // Constructor chaining

    static class ServerConfig {
        String url;
        int port;
        int timeout;

        //1 master constructor (Handles all logic)
        public ServerConfig(String url, int port, int timeout) {
            this.url = url;
            this.port = port;
            this.timeout = timeout;
            System.out.println("Server configured " + url + " : " + port + " Timeout: " + timeout + "ms");
        }

        // Partial constructor (Delegates to master)
        public ServerConfig(String url, int port) {
            this(url, port, 5000);// calls the 3 arg constructor
        }

        // Minimal constructor (Delegates to partial)
        public ServerConfig(String url) {
            this(url, 8080);// calls the 2 arg constructor
        }
    }

        public void demonstrateChaining(){
            System.out.println(" 1-- Constructor chaining (this)");
            new ServerConfig("https://myserver.com");
            new ServerConfig("https://db-server.com",3306);
        }
        // - - 2 PARENT CONSTUCTOR CALL(super)
        class User{
         String name;
         User(String name){
             this.name=name;
             System.out.println("User created "+name);
         }
        }

        class Admin extends User{
          String permissionlevel;
            Admin(String name, String permissionLevel) {
                super(name);// must be first line
                this.permissionlevel=permissionLevel;
                System.out.println("Admin privileges granted "+permissionLevel);
            }
        }

        public void demonstrateSuper(){
            System.out.println("\n---2 parent constructor (super)--");
            new Admin("Alice","Superuser");
        }

        public static void main(String[] args){
        ConstructorsLesson constructorsLesson=new ConstructorsLesson();
        constructorsLesson.demonstrateChaining();
        constructorsLesson.demonstrateSuper();
        }
    }
