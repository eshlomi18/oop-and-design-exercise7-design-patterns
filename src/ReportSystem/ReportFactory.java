package ReportSystem;

import java.util.List;

public class ReportFactory {

    public static Report createReport(String typeCode, String content, List<String> decoratorCodes) {
        Report report;

        // יצירת הדוח הבסיסי לפי הסוג
        switch (typeCode) {
            case "1":
                report = new IncidentReport(content);
                break;
            case "2":
                report = new MovementReport(content);
                break;
            case "3":
                report = new ContactReport(content);
                break;
            case "4":
                report = new RoutineReport(content);
                break;
            default:
                throw new IllegalArgumentException("Invalid report type: " + typeCode);
        }

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
