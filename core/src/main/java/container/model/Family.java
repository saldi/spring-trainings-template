package container.model;

import container.Component;

@Component
public class Family {

    private Person son;
    private Person mother;
    private Person sister;

    public Family(Person son, Person mother, Person sister) {
        this.son = son;
        this.mother = mother;
        this.sister = sister;
    }

    @Override
    public String toString() {
        return "Family{" +
                "son=" + son +
                ", mother=" + mother +
                ", sister=" + sister +
                '}';
    }
}
