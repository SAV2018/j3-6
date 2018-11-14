package hw3_6;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;


@RunWith(Parameterized.class)
public class MainTest {
    private Object[] inArray, outArray;

    public MainTest(Object[] inArray, Object[] outArray) {
        this.inArray = inArray;
        this.outArray = outArray;
    }

    @Parameterized.Parameters
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][]{
                {new Integer[]{1, 2, 4, 4, 2, 3, 4, 1, 7}, new Integer[]{1, 7}},
                {new Integer[]{1, 2, 3, 4}, new Integer[]{}},
                {new Integer[]{1, 2, 3, 4, 0, 15, 2}, new Integer[]{0, 15, 2}}
        });
    }

    @Test
    public void getNewArray() {
        Assert.assertArrayEquals(outArray, Main.getNewArray((Integer[]) inArray));
    }

    @Test(expected = RuntimeException.class)
    public void getNewArrayNotFound() {
        Assert.assertArrayEquals(new Object[]{1, 2, 3}, Main.getNewArray(new Integer[]{}));
    }
}