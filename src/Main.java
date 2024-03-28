import java.util.Scanner;


public class Main {
    public static void main(String[] args) throws Exception {
        Scanner scn = new Scanner(System.in);
        String calc = scn.nextLine();
        char oper;
        String[] data;
        if (calc.contains(" + ")) {
            data = calc.split(" \\+ ");
            oper = '+';
        } else if (calc.contains(" - ")) {
            data = calc.split(" - ");
            oper = '-';
        } else if (calc.contains(" * ")) {
            data = calc.split(" \\* ");
            oper = '*';
        } else if (calc.contains(" / ")) {
            data = calc.split(" / ");
            oper = '/';
        }else{
            throw new Exception("Неправильный знак действия");

        }
        if (oper == '*' || oper == '/') {
            if (data[1].contains("\"")) throw new Exception("Строчку можно делить или умножать только на число");
        }
        for (int i = 0; i < data.length; i++) {
            data[i] = data[i].replace("\"", "");
        }

        if (oper == '+') {
            print(data[0] + data[1]);
        } else if (oper == '*') {
            int m = Integer.parseInt(data[1]);
            String result = "";
            for (int i = 0; i < m; i++) {
                result+=data[0];
            }
            print(result);
        } else if (oper == '-') {
            int index = data[0].indexOf(data[1]);
            if(index == -1){
                print(data[0]);
            }else{
                String result = data[0].substring(0, index);
                result+=data[0].substring(index+data[1].length());
                print(result);
            }
        }else{
            int newLen = data[0].length()/Integer.parseInt(data[1]);
            String result = data[0].substring(0,newLen);
            print(result);
        }

    }
    static void print(String text){
        System.out.println("\""+text+"\"");
    }


}