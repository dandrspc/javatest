package me.dapac.javatests.util;

import org.junit.Assert;
import org.junit.Test;

public class StringUtilTest {

    @Test
    public void repeapt_string_once() {
        Assert.assertEquals("hola", StringUtil.repeat("hola", 1));
    }


    @Test
    public void repeatStingMultipleTimes() {
        Assert.assertEquals("holaholahola", StringUtil.repeat("hola", 3));
    }

    @Test
    public void repeatStringZeroTimes() {
        Assert.assertEquals("", StringUtil.repeat("hola", 0));
    }

    @Test(expected = IllegalArgumentException.class)
    public void repeatStringNegativeTimes() {
        Assert.assertEquals("", StringUtil.repeat("hola", -1));
    }

    @Test
    public void string_not_empty() {
        Assert.assertFalse(StringUtil.isEmpty("hola"));
    }

    @Test
    public void validate_empty_string(){
        Assert.assertTrue(StringUtil.isEmpty(""));
    }

    @Test
    public void validate_null_string() {
        Assert.assertTrue(StringUtil.isEmpty(null));
    }

    @Test
    public void validate_white_string(){
        Assert.assertTrue(StringUtil.isEmpty(" "));
    }
}