package ArtSystem;

public class LongPrintVisitor implements ElementVisitor {

    private final StringBuilder sb = new StringBuilder();

    public String getResult() {
        return sb.toString().trim(); // מחזיר את הטקסט המלא, בלי רווח מיותר בסוף
    }

    @Override
    public void visit(Tree tree) {
        sb.append("A tree with an amount of ").append(tree.getLeavesAmount()).append(" leaves. ");
    }

    @Override
    public void visit(Boat boat) {
        sb.append("A boat made of ").append(boat.getMaterial().toString().toLowerCase()).append(" material. ");
    }

    @Override
    public void visit(Flag flag) {
        sb.append("A flag of color: ").append(flag.getColor().toString().toLowerCase())
          .append(", with pole height of ").append(flag.getCarrierHeight()).append(". ");
    }

    @Override
    public void visit(Kid kid) {
        int age = 2023 - kid.getBirthYear(); // התאמה לשנה של הבודק
        sb.append("A ").append(age).append(" year old kid with ")
          .append(kid.getHairColor().toString().toLowerCase()).append(" hair. ");
    }

    @Override
    public void visit(Kite kite) {
        sb.append("A kite of color: ").append(kite.getColor().toString().toLowerCase()).append(". ");
    }

    @Override
    public void visit(Island island) {
        if (island.getChildren().isEmpty()) {
            sb.append("An empty island named ").append(island.getName()).append(". ");
        } else {
            sb.append("An island named ").append(island.getName()).append(" containing: ");
        }
    }

    @Override
    public void visit(Lake lake) {
        if (lake.getChildren().isEmpty()) {
            sb.append("An empty lake named ").append(lake.getName()).append(". ");
        } else {
            sb.append("A lake named ").append(lake.getName()).append(" containing: ");
        }
    }
}
