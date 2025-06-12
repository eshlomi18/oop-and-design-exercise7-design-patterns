package ArtSystem;

public interface ElementVisitor {
    void visit(Tree tree);

    void visit(Boat boat);

    void visit(Flag flag);

    void visit(Kid kid);

    void visit(Kite kite);

    void visit(Island island);

    void visit(Lake lake);
}

