package ArtSystem;

import java.util.ArrayList;
import java.util.List;

public class Lake extends Element {
    private String name;
    private List<Element> children;

    public Lake(String name, double diameter, String path) {
        super(diameter, diameter, path); // עגול – הקוטר שווה לרוחב ולאורך
        this.name = name;
        this.children = new ArrayList<>();
    }

    public void addChild(Element child) {
        if (child.getHabitat() == Habitat.AQUATIC || child.getHabitat() == Habitat.AMPHIBIAN) {
            children.add(child);
        } else {
            System.out.println(getFullName() + " cannot contain " + child.getName());
        }
    }

    public List<Element> getChildren() {
        return children;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public Habitat getHabitat() {
        return Habitat.TERRESTRIAL; // כי אגם יושב על קרקע
    }

    @Override
    public void accept(ElementVisitor visitor) {
        visitor.visit(this);
        for (Element child : children) {
            child.accept(visitor);
        }
    }
}
