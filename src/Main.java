import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;

import ArtSystem.*;
import ReportSystem.Report;
import ReportSystem.ReportFactory;


import static java.util.stream.Collectors.toMap;

public class Main {

    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Choose from the following options:\n" +
                "a: Art\n" +
                "r: Reports");
        String choice = scanner.nextLine();
        if (choice.equals("a")) {
            artMenu(scanner);
        }
        if (choice.equals("r")) {
            reportsMenu(scanner);
        }
    }

    public static Painting readElementDetails(String path) throws IOException {
        Painting painting = new Painting();
        Map<String, Element> files = new HashMap<>();

        Files.lines(Paths.get(path))
                .map(str -> ElementDetailsFactory.getPaintingElement(str))
                .forEach(e -> painting.addElement(e));
        return painting;
    }

    public static void artMenu(Scanner scanner) throws IOException {
        System.out.println("Enter the path of the painting description");
        String path = scanner.nextLine();
        Painting root = readElementDetails(path);
        System.out.println("Choose from the following options:\n" +
                "q: quit\n" +
                "c: count elements\n" +
                "lp: long print\n" +
                "sh: short print\n" +
                "ta: total area");
        String myString;
        while (!(myString = scanner.nextLine()).equals("q")) {
            switch (myString) {
                case "c":
                    CountVisitor countVisitor = new CountVisitor();
                    root.acceptAllElements(countVisitor);
                    System.out.println(countVisitor.getCount());
                    break;

                case "sh":
                    ShortPrintVisitor shortVisitor = new ShortPrintVisitor();
                    root.acceptAllElements(shortVisitor);
                    break;

                case "ta":
                    TotalAreaVisitor areaVisitor = new TotalAreaVisitor();
                    root.acceptAllElements(areaVisitor);
                    System.out.println(areaVisitor.getTotalAreaRounded());
                    break;

                case "lp":
                    LongPrintVisitor longVisitor = new LongPrintVisitor();
                    root.acceptAllElements(longVisitor);
                    System.out.println(longVisitor.getResult());
                    break;
            }
        }
    }


    public static void reportsMenu(Scanner sc) {
        System.out.println("Choose report type:");
        System.out.println("1 - Incident");
        System.out.println("2 - Movement");
        System.out.println("3 - Contact");
        System.out.println("4 - Routine");

        String type = sc.nextLine().trim();

        System.out.println("Enter the report content:");
        String content = sc.nextLine();

        System.out.println("Add decorators one by one (enter code). Type 's' to submit and print the report:");
        System.out.println("u - Urgent ([URGENT] at the start)");
        System.out.println("c - Classified ([CLASSIFIED] at the end)");
        System.out.println("t - To Commander ([TO COMMANDER] at the end)");
        System.out.println("a - Audio Attachment ([AUDIO ATTACHED] at the end)");

        // איסוף קודים של הקישוטים
        List<String> decoratorCodes = new ArrayList<>();
        while (true) {
            String dec = sc.nextLine().trim().toLowerCase();
            if (dec.equals("s")) break;
            decoratorCodes.add(dec);
        }

        // שימוש בפקטורי כדי לבנות את הדוח
        Report report;
        try {
            report = ReportFactory.createReport(type, content, decoratorCodes);
        } catch (Exception e) {
            report = null;
        }

        if (report != null)
            System.out.println(report.getContent());
        else
            System.out.println("Report construction failed. Check implementation.");
    }

}
