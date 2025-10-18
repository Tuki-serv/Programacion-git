import com.sun.security.jgss.GSSUtil;

import java.util.HashMap;
import java.util.Map;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        Curso c1 = new Curso("mate", "laura");
        Curso c2 = new Curso("quimica", "pedro");
        Curso c3 = new Curso("lengua", "alberto");

        Map<String,Curso> cursos = new HashMap<>();
        cursos.put("1",c1);
        cursos.put("2",c2);
        cursos.put("3",c3);

        System.out.println(cursos.get("1"));
        System.out.println(cursos.get("2"));
        System.out.println(cursos.get("3"));

        System.out.println("\n");
        for (Map.Entry<String,Curso> entrada : cursos.entrySet()){
            System.out.println("Curso: "+ entrada.getKey()+", Valor: "+ entrada.getValue());
        }
    }
}