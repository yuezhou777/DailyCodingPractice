package OOD.Singleton;

public class Singleton {
    private static Singleton instance;

    private Singleton(){
        //do sth;
    }

//    public static Singleton getInstance() {
//        //do sth..a
//        if (instance == null) {
//            synchronized(this) {
//                if (instance == null) {
//                    instance = new Singleton();
//                }
//            }
//        }
//        //do sth..b
//        return instance;
//    }
}
