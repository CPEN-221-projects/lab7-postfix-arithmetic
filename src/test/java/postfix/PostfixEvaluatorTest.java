package postfix;

import static org.junit.Assert.*;

import org.junit.Test;
import parser.MalformedExpressionException;

public class PostfixEvaluatorTest {

	@Test
	public void test1() throws MalformedExpressionException {
	    assertEquals(7, new PostfixEvaluator("5 2 +").eval(), 0);
	}

    @Test
    public void test2() throws MalformedExpressionException {
        assertEquals(8, new PostfixEvaluator("5 2 + 7 - 8 +").eval(), 0);
    }

    @Test
    public void test3() throws MalformedExpressionException {
        assertEquals(-40, new PostfixEvaluator("5 2 + 7 - 8 + 0 5 - *").eval(), 0);
    }

    @Test(expected = MalformedExpressionException.class)
    public void test4() throws MalformedExpressionException {
        assertEquals(-40, new PostfixEvaluator("5 2 + 7 - 8 + 0 5 - * +").eval(), 0);
    }

    @Test(expected = MalformedExpressionException.class)
    public void test5() throws MalformedExpressionException {
        new PostfixEvaluator("+").eval();
    }

    @Test
    public void doMyPrarielearn() throws MalformedExpressionException {
        assertEquals(95, new PostfixEvaluator("11 10 2 - * 7 +").eval(), 0);
        assertEquals(126, new PostfixEvaluator("18 7 + 4 - 6 *").eval(), 0);
    }
}
