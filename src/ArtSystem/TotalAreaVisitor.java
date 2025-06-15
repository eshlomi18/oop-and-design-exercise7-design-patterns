package ArtSystem;

public class TotalAreaVisitor implements ElementVisitor {
    private double total = 0;

    public int getTotalAreaRounded() {
        return (int) Math.round(total);
    }

    @Override
    public void visit(Tree tree) {
        double tri = tree.getLength() * (tree.getWidth() / 2.0);
        total += tri;
    }

    @Override
    public void visit(Boat boat) {
        double rect = boat.getWidth() / 2 * boat.getLength();
        double halfCircle = Math.PI * Math.pow(boat.getWidth() / 2.0, 2) / 2;
        total += rect + halfCircle;
    }

    @Override
    public void visit(Flag flag) {
        total += flag.getWidth() * flag.getLength();
    }

    @Override
    public void visit(Kid kid) {
        double rect = kid.getWidth() * (kid.getLength() - kid.getWidth());
        double circle = Math.PI * Math.pow(kid.getWidth() / 2.0, 2);
        total += rect + circle;
    }

    @Override
    public void visit(Kite kite) {
        total += (kite.getWidth() * kite.getLength()) / 2.0;
    }

    @Override
    public void visit(Island island) {
        double radius = island.getWidth() / 2.0;
        total += Math.PI * radius * radius;
    }

    @Override
    public void visit(Lake lake) {
        double radius = lake.getWidth() / 2.0;
        total += Math.PI * radius * radius;
    }
}



