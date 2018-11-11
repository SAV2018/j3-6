package hw3_6;

import junit.framework.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

@RunWith(Parameterized.class)
public class MainTest_1 {
    private boolean result;
    private Integer[] array;

    public MainTest_1(Integer[] array, boolean result) {
        this.result = result;
        this.array = array;
    }

    @Parameterized.Parameters
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][]{
                {new Integer[]{1, 1, 4, 4, 1, 1, 4, 1, 1}, true},
                {new Integer[]{1, 4}, true},
                {new Integer[]{1, 1, 1}, false},
                {new Integer[]{4}, false},
                {new Integer[]{}, false}
        });
    }

    @Test
    public void checkArray() {
        Assert.assertEquals(result, Main.checkArray(array));
    }
}