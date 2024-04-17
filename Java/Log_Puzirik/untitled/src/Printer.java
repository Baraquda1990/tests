import java.io.File;
import java.io.FileWriter;
import java.io.FileReader;
import java.io.BufferedReader;
import java.io.IOException;
import java.util.Arrays;
import java.text.SimpleDateFormat;
import java.util.Date;

class BubbleSort {
    private static File log;
    private static FileWriter fileWriter;

    public static void sort(int[] mas) {


        String pattern = "yyyy-MM-dd hh:mm";
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);
        String date = simpleDateFormat.format(new Date());
        int n=0;
        Boolean flag;
        try{
            FileWriter log=new FileWriter("log.txt");
            int i=0;
            int j=0;
            int k=mas.length;
            while(i<k) {
                flag=false;
                while (j<k-1-i) {
                    int vrem = 0;
                    if (mas[j] > mas[j + 1]) {
                        vrem = mas[j + 1];
                        mas[j + 1] = mas[j];
                        mas[j] = vrem;
                        flag=true;
                    }
                    j++;
                }
                log.write(date+" "+"[");
                n=0;
                while(n<mas.length){
                    if(n!=mas.length && n!=0){
                        log.write(", ");
                    }
                    log.write(String.valueOf(mas[n]));
                    if(n==mas.length-1){
                        log.write("]\n");
                    }
                    n++;
                }
                if(!flag) break;
                j = 0;
                i++;
            }
            log.close();
        }catch(IOException e){
            System.out.println("Ошибка при записи в файл: " + e.getMessage());

        }
    }
}

// Не удаляйте этот класс - он нужен для вывода результатов на экран и проверки
public class Printer{
    public static void main(String[] args) {
        int[] arr = {};

        if (args.length == 0) {
            // При отправке кода на Выполнение, вы можете варьировать эти параметры
            arr = new int[]{9, 3, 4, 8, 2, 5, 7, 1, 6, 10};
        }
        else{
            arr = Arrays.stream(args[0].split(", "))
                    .mapToInt(Integer::parseInt)
                    .toArray();
        }

        BubbleSort ans = new BubbleSort();
        ans.sort(arr);

        try (BufferedReader br = new BufferedReader(new FileReader("log.txt"))) {
            String line;
            while ((line = br.readLine()) != null) {
                System.out.println(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}