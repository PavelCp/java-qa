import java.util.HashMap;

public class App {


    public static void main(String[] args) {

        HashMap<String, Integer> disciplines1 = new HashMap<>(), disciplines2 = new HashMap<>();
        disciplines1.put("Java", 16);
        disciplines1.put("JDBC", 24);
        disciplines1.put("Spring", 30);
        disciplines2.put("Test design", 160);
        disciplines2.put("Page Object", 24);
        disciplines2.put("Selenium", 36);
        Student st1 = new Student("Ivan", new String[]{"2025", "2", "2"}, "Automation", disciplines1);
        Student st2 = new Student("Petr", new String[]{"2025", "3", "1"}, "SDET", disciplines1);
        Student st3 = new Student("Semen", new String[]{"2025", "2", "1"}, "Manual to Automation", disciplines2);

        Student.makeReport(st1, false);
        Student.makeReport(st2, false);
        Student.makeReport(st3, false);
    }
}