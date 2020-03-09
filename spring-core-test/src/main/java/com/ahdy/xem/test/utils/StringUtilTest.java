package com.ahdy.xem.test.utils;

import com.ahdy.xem.common.utils.AesUtil;
import com.ahdy.xem.common.utils.StringUtil;

public class StringUtilTest {

    public static void main(String[] args) {
        String random = AesUtil.genAesKey();
        System.out.println(random);
    }

}
