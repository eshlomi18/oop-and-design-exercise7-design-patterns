package ArtSystem;

import java.util.ArrayList;
import java.util.List;

public class Island extends Element {
    private String name;
    private List<Element> children;

    public Island(String name, double diameter, String path) {
        super(diameter, diameter, path); // גם האי הוא עגול
        this.name = name;
        this.children = new ArrayList<>();
    }

    public void addChild(Element child) {
        if (child.getHabitat() == Habitat.TERRESTRIAL || child.getHabitat() == Habitat.AMPHIBIAN) {
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
        return Habitat.AQUATIC; // האי נמצא בתוך מים
    }

    @Override
    public void accept(ElementVisitor visitor) {
        visitor.visit(this);
        for (Element child : children) {
            child.accept(visitor);
        }
    }
}
