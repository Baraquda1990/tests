import java.util.Arrays;
class MergeSort {
    public static int[] mergeSort(int[] a) {
        if(a.length==1 || a.length==0){
            return a;
        }
        int d=a.length/2;
        int i=0;
        int [] ll=new int[d];
        int [] rr=new int[a.length-d];
        int n=0;
        int m=0;
        for(i=0;i<a.length;i++){
            if(i<d){
                ll[n]=a[i];
                n++;
            }else{
                rr[m]=a[i];
                m++;
            }
        }
        int [] l=mergeSort(ll);
        int [] r=mergeSort(rr);
        n=0;
        m=0;
        int k=0;
        int [] c=new int[a.length];
        while(n<l.length && m<r.length){
            if(l[n]<=r[m]){
                c[k]=l[n];
                n++;
            }else{
                c[k]=r[m];
                m++;
            }
            k++;
        }
        while(n<l.length){
            c[k]=l[n];
            n++;
            k++;
        }
        while(m<r.length){
            c[k]=r[m];
            m++;
            k++;
        }
        return (c);
    }
}
// Не удаляйте этот класс - он нужен для вывода результатов на экран и проверки
public class Printer{
    public static void main(String[] args) {
        int[] a;

        if (args.length == 0) {
            // При отправке кода на Выполнение, вы можете варьировать эти параметры
            a = new int[]{5, 1, 6, 2, 3, 4};
        } else {
            a = Arrays.stream(args[0].split(", ")).mapToInt(Integer::parseInt).toArray();
        }

        MergeSort answer = new MergeSort();
        String itresume_res = Arrays.toString(answer.mergeSort(a));
        System.out.println(itresume_res);
    }
}