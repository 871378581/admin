package com.segama.ege.util;

public class PageCountUtil {

    public  static int computeTotalPageByCount(int totalRecord, int showCount)
    {
        int totalPage = 1;
        if(totalRecord> showCount)
        {
            if(totalRecord%showCount ==0)
            {
                totalPage = totalRecord/showCount;
            }else {
                totalPage = 1 + totalRecord/showCount;
            }
        }
        return totalPage;
    }
}
