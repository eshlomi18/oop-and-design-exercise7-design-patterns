package ArtSystem;

public class CountVisitor implements ElementVisitor {
    private int count = 0;

    public int getCount() {
        return count;
    }

    @Override
    public void visit(Tree tree) {
        count++;
    }

    @Override
    public void visit(Boat boat) {
        count++;
    }

    @Override
    public void visit(Flag flag) {
        count++;
    }

    @Override
    public void visit(Kid kid) {
        count++;
    }

    @Override
    public void visit(Kite kite) {
        count++;
    }

    @Override
    public void visit(Island island) {
        count++;
    }

    @Override
    public void visit(Lake lake) {
        count++;
    }
}
