package dev.brenr.formelements;

public class Dragger {
    public void drag(Draggable draggable) {
        draggable.drag();
        System.out.println("Dragging done!");
    }
}
