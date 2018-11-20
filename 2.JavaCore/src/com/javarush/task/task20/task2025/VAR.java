package com.javarush.task.task20.task2025;

public class VAR {

    public static void main(String[] args)
    {
        long a = System.currentTimeMillis();
        int[] n = getNumbers(199999999);
        long b = System.currentTimeMillis();
        System.out.println(b - a);
        long usedBytes = Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory();
        System.out.println(usedBytes / (1024 * 1024));
        for (int i = 0; i < n.length; i++) {
            System.out.println(n[i]);

        }

    }

    public static int[] getNumbers(int N)
    {

        int[][] pow = new int[10][11];
        for (int row = 1; row < pow.length; row++)
        {
            for (int column = 1; column < pow[row].length; column++)
            {
                pow[row][column] = (int) Math.pow(row, column);
            }
        }

        int[] result = null;
        int[] res = new int[N];
        int count = 0;
        for (int i = 1; i <= N; i++)
        {

            byte m;

            if (i < 100000)
            {
                // 5 or less
                if (i < 100)
                {
                    // 1 or 2
                    if (i < 10)
                        m = 1;
                    else
                        m = 2;
                } else
                {
                    // 3 or 4 or 5
                    if (i < 1000)
                        m = 3;
                    else
                    {
                        // 4 or 5
                        if (i < 10000)
                            m = 4;
                        else
                            m = 5;
                    }
                }
            } else
            {
                // 6 or more
                if (i < 10000000)
                {
                    // 6 or 7
                    if (i < 1000000)
                        m = 6;
                    else
                        m = 7;
                } else
                {
                    // 8 to 10
                    if (i < 100000000)
                        m = 8;
                    else
                    {
                        // 9 or 10
                        if (i < 1000000000)
                            m = 9;
                        else
                            m = 10;
                    }
                }
            }

            int l = 0;
            for (int j = i; j > 0; j /= 10)
            {
                int last = j % 10;
                if (last != 0)
                {
                    int v = pow[last][m];
                    l = l + v;
                }

            }
            if (l == i)
            {
                res[count++] = i;
            }

        }
        count = 0;

        for (int a : res)
        {
            if (a > 0)
            {
                count++;
            }
        }
        result = new int[count];

        count = 0;
        for (int a : res)
        {
            if (a > 0)
            {
                result[count++] = a;
            }
        }
        return result;
    }

}
