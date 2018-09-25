package container;

import container.model.Family;
import container.model.Person;

public class MyDIContainerTest {

    public static void main(String[] args) {

        MyDIContainer container =
                new MyDIContainer("container.model");

        Family family = container.getObject(Family.class);
        System.out.println(family);

    }


}
