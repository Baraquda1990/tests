import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Set;


//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        HashMap<Integer,String> kniga=new HashMap<>();
        kniga.put(163131, "Damir");
        kniga.put(163030,"Arsen");
        kniga.put(163400,"Vlad");
        kniga.put(163402,"Aleksander");
        kniga.put(163078,"Zhanna");
        kniga.put(163111,"Yuriy");
        kniga.put(163100,"Tolyan");
        kniga.put(160303,"Arsen");
        kniga.put(161313,"Damir");
        Integer[] keys = kniga.keySet().toArray(new Integer[kniga.size()]);
        Arrays.sort(keys, Comparator.reverseOrder());
        for(int i=0;i<keys.length;i++){
            System.out.printf("Number:%d,Name:%s\n",keys[i],kniga.get(keys[i]));
        }

    }
}