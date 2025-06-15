package ReportSystem;

public abstract class ReportDecorator implements Report {
    protected final Report report;

    public ReportDecorator(Report report) {
        this.report = report;
    }

    @Override
    public String getType() {
        return report.getType();
    }

    @Override
    public abstract String getContent(); // כל דקורטור יגדיר את זה בעצמו
}
