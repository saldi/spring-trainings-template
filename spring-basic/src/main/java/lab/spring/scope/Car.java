package lab.spring.scope;

import lombok.Value;
import org.springframework.stereotype.Component;

@Component
public class Car {

    private Tire lf;
    private Tire rf;
    private Tire rr;
    private Tire lr;

    public Car(Tire lf, Tire rf, Tire rr, Tire lr) {
        this.lf = lf;
        this.rf = rf;
        this.rr = rr;
        this.lr = lr;
    }

    @Override
    public String toString() {
        return "Car{" +
                "lf=" + lf +
                ", rf=" + rf +
                ", rr=" + rr +
                ", lr=" + lr +
                '}';
    }
}
