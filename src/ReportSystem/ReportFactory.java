package ReportSystem;

import java.util.List;

public class ReportFactory {

    public static Report createReport(String typeCode, String content, List<String> decoratorCodes) {
        Report report = switch (typeCode) {
            case "1" -> new IncidentReport(content);
            case "2" -> new MovementReport(content);
            case "3" -> new ContactReport(content);
            case "4" -> new RoutineReport(content);
            default -> throw new IllegalArgumentException("Invalid report type: " + typeCode);
        };

        // יצירת הדוח הבסיסי לפי הסוג

        // הוספת הקישוטים לפי הסדר
        for (String code : decoratorCodes) {
            switch (code.toLowerCase()) {
                case "u":
                    report = new UrgentReportDecorator(report);
                    break;
                case "c":
                    report = new ClassifiedReportDecorator(report);
                    break;
                case "t":
                    report = new CommanderTagReportDecorator(report);
                    break;
                case "a":
                    report = new AudioAttachmentReportDecorator(report);
                    break;
                default:
                    System.out.println("Unknown decorator code: " + code);
            }
        }

        return report;
    }
}
