package ArtSystem;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Painting {
    Map<String, Element> pathToElementMap;
    List<Element> elementList;

    public Painting() {
        elementList = new ArrayList<>();
        pathToElementMap = new HashMap<>();
    }

    public void addElement(Element element) {
        pathToElementMap.put(element.getFullName(), element);
        if (element.getPath().isEmpty()) {
            elementList.add(element); // root-level
        } else {
            Element containingElement = pathToElementMap.get(element.getPath());
            if (containingElement instanceof Lake) {
                ((Lake) containingElement).addChild(element);
            } else if (containingElement instanceof Island) {
                ((Island) containingElement).addChild(element);
            } else {
                System.out.println("Cannot add element to " + containingElement.getName());
            }
        }
    }


    public String getName() {
        return Painting.class.getSimpleName().toLowerCase();
    }

    public void acceptAllElements(ElementVisitor visitor) {
        for (Element element : elementList) {
            element.accept(visitor);
        }
    }

}
