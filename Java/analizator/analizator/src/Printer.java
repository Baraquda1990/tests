//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
import java.util.Arrays;
import java.util.ArrayList;
import java.util.Collections;

class Answer {
    public static void analyzeNumbers(Integer[] arr) {
        ArrayList<Integer> list=new ArrayList<>();
        for (int i = 0; i < arr.length; i++) {
            list.add(arr[i]);
        }
        Collections.sort(list);
        int mx=Collections.max(list);
        int mn=Collections.min(list);
        System.out.println(list.toString());
        //String f=String.format("Minimum is %d",mn);
        //System.out.println(f);
        //f=String.format("Maximum is %d",mx);
        //System.out.println(f);
        System.out.printf("Minimum is %d\n",mn);
        System.out.printf("Maximum is %d\n",mx);
        int sum=0;
        int i=0;
        while(i<list.size()){

            sum=sum+list.get(i);
            System.out.println(list.get(i)+" "+sum+" "+i);
            i++;
        }
        double summ=(double)sum;
        Double aver= summ/list.size();
        System.out.println(aver);
        System.out.printf("Average is = %.1f",aver);
    }
}

// Не удаляйте этот класс - он нужен для вывода результатов на экран и проверки
public class Printer{
    public static void main(String[] args) {
        Integer[] arr = {};

        if (args.length == 0) {
            // При отправке кода на Выполнение, вы можете варьировать эти параметры
            arr = new Integer[]{-2,-1,0,1,2,3,4,5};
        }
        else{
            arr = Arrays.stream(args[0].split(", "))
                    .map(Integer::parseInt)
                    .toArray(Integer[]::new);
        }

        Answer ans = new Answer();
        ans.analyzeNumbers(arr);
    }
}