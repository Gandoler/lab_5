import java.io.File;

public class Main {
    public static void main(String[] args) {
        try {
            new Plotter(new File("/Users/gl.krutoimail.ru/Desktop/labs/programirovanye/java_lab/Lab_4/lab_5.log"));
        }catch (Exception e){
            System.out.println(e);
        }

    }
}