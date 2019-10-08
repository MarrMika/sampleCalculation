import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    static private String s1 = "1.Find mode"; //+
    static private String s2 = "2.Find median"; //+
    static private String s3 = "3.Find mean"; //+
    static private String s4 = "4.Find dispertion"; //+
    static private String s5 = "5.Square dispertion"; //+
    static private String s6 = "6.Sort"; //+
    static private String s7 = "7.Change bounds"; //+
    static private String s8 = "8.Find IQR"; //+
    static private String s9 = "9.Find scope(max-min)"; //+



    static Controller controller;
    static List<Integer> list = null;



    public static void main(String[] args) {
        controller = new Controller();
        list = new ArrayList<>();
        //controller.randomList(list);
        list.add(8);list.add(13);list.add(17);
        list.add(19);list.add(21);list.add(23);list.add(23);
        list.add(24);list.add(30);list.add(35);


        for(;;) {  //while(1)
            System.out.println("\n");
            System.out.println("<---Menu--->");
            System.out.println(s1);
            System.out.println(s2);
            System.out.println(s3);
            System.out.println(s4);
            System.out.println(s5);
            System.out.println(s6);
            System.out.println(s7);
            System.out.println(s8);
            System.out.println(s9);
            System.out.println("0.Exit");
           // System.out.println("\n");
            Scanner keyboard = new Scanner(System.in);
            System.out.print("->Enter a number:_");
            int var = keyboard.nextInt();
            if(var!=0) {
                new Main().menu(var);
            } else {
                System.out.println("\n");
                System.out.println("                              Exit");
                System.out.println("\n");
                break;
            }
        }

    }

    void menu(int var){
        switch(var){
            case 1: {
                System.out.println("-------------------------------------------------------");
                System.out.println("Modes: "+ controller.getMode(list));
                System.out.println("-------------------------------------------------------");
                break;
            }
            case 2:{//+
                System.out.println("-------------------------------------------------------");
                System.out.println("Median: "+controller.getMedian(list));
                System.out.println("-------------------------------------------------------");

                break;
            }
            case 3:{//+
                System.out.println("-------------------------------------------------------");
                System.out.println("An Average number is: " + controller.getMean(list));
                System.out.println("-------------------------------------------------------");
                break;
            }

            case 4:{//+
                System.out.println("-------------------------------------------------------");
                System.out.println("Dispertion: " + controller.getDispersion(list));
                System.out.println("-------------------------------------------------------");
                break;
            }
            case 5:{//+
                System.out.println("-------------------------------------------------------");
                System.out.println("A Square dispertion: " + Math.sqrt(controller.getDispersion(list)));
                System.out.println("-------------------------------------------------------");
                break;
            }
            case 6:{//+
                System.out.println("-------------------------------------------------------");
                final List<Integer> sortedList = controller.getSortedList(list);
                System.out.println("Sorted list: " + sortedList);
                System.out.println("-------------------------------------------------------");
                break;
            }
            case 7:{//+
                System.out.println("-------------------------------------------------------");
                controller.randomList(list);
                System.out.println("-------------------------------------------------------");
                break;
            }
            case 8:{//+
                System.out.println("-------------------------------------------------------");
                double [] arr = controller.getQuartile(controller.getSortedList(list));
                System.out.println("IQR:" + arr[3]);
                System.out.println("-------------------------------------------------------");
                break;
            }
            case 9:{//+
                System.out.println("-------------------------------------------------------");
                System.out.println("Scope(max-min):"+controller.getScope(list));
                System.out.println("-------------------------------------------------------");
                break;
            }
            default: {
                System.out.println("-------------------------------------------------------");
                System.out.println("User has chosen nothing!");
                System.out.println("-------------------------------------------------------");
                break;

            }

        }
    }

}
