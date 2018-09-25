package lab.spring.spel;

import org.springframework.expression.EvaluationContext;
import org.springframework.expression.Expression;
import org.springframework.expression.ExpressionParser;
import org.springframework.expression.spel.standard.SpelExpressionParser;
import org.springframework.expression.spel.support.StandardEvaluationContext;
import org.testng.Assert;
import org.testng.annotations.Test;

public class SpelTest {

    @Test
    public void convertTest() {

        Person input = new Person("Jan", "Kowalski");
        Person output = new Person("", "");
        convertPersons(input, output);
        Assert.assertEquals(input.getFirstName(), output.getFirstName());

    }


    void convertPersons(Object input, Object output) {

        ExpressionParser parser = new SpelExpressionParser();
        Expression exp = parser.parseExpression("firstName");
        EvaluationContext context = new StandardEvaluationContext(input);
        String firstName = exp.getValue(context, String.class);

        System.out.println(firstName);

        context = new StandardEvaluationContext(output);
        exp.setValue(context, firstName);

    }


}
