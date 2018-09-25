package lab.spring.cepik;

public class SystemPropertiesPresenter implements Runnable {

    @Override
    public void run() {

        System.getProperties()
                .forEach((o, o2) -> {
                    System.out.println(Thread.currentThread().getName()+" "+o + " " + o2);
                });


    }
}
