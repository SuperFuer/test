/**
 * @author : peng
 * @creation : 2019/5/9
 * @description :
 */
public class Test {

    /**
     * 题1中用到的变量
     */
    static String s = "This is C programming text";
    static String t = "This is a text for C programming";

    /**
     * 题2中用到的全局变量
     */
    static int sum = 0;     //若干整数的和
    static int n = 15;       //整数N
    static int[] result = new int[n];    //结果集数组,不确定整数N有多大，默认创建一个整数N大小的数组
    static int index = -1;  //记录当前递归指向结果集中那些元素
    static int count = 0;   //可分解次数

    public static void main(String[] args) {
        testOne(s, t);
        testTwo(1);
    }

    /**
     * 获取两个字符串中相同的单词(大小写也相同，如果想忽略大小写的判断，将判断改为equalsIgnoreCase)
     * 字符串由单词和空格组成，根据空格解析字符串为数组，遍历两个数组中是否存在相同单词
     * @param s
     * @param t
     * @return
     */
    public static String testOne(String s, String t){
        //判断某一个字符串为空，直接返回null
        if(s.length() < 1 || s == null || t.length() < 1 || t == null){
            return null;
        }
        String[] sAry = s.split(" ");
        String[] tAry = t.split(" ");
        for(int i = 0; i < sAry.length; i++){
            for (int z = 0; z < tAry.length; z++){
                if(sAry[i].equals(tAry[z])){
                    System.out.println("题目1结果：");
                    //如果判断相等，打印第一次成立的结果
                    System.out.println(sAry[i] + "\n");
                    return sAry[i];
                }
            }
        }
        return null;
    }

    /**
     * 使用递归 给结果集数组加值，修改结果集之后判断和是否等于整数N，再判断是否满足连续整数
     * @param z
     */
    private static void testTwo(int z) {
        //若干整数的和 等于 整数N时 结果数组中的值加起来等于整数N
        if (sum == n) {
            //临时计数器 判断结果集中 是否是连续的整数
            int in = 0;
            for(int i = 0; i < index; i++){
                if((result[i] + 1) == (result[i + 1])){
                    in++;
                }
            }
            //当计数器等于结果集指向时 输入连续整数集合
            if(in == index && index != 0){
                count++;
                if(count == 1){
                    System.out.println("题目2结果：");
                }
                for (int i = 0; i < index + 1; i++){
                    System.out.print(result[i] + " ");
                }
                System.out.println();
            }
            //count等于0 说明整数N没有连续整数的和的集合
            if(in == index && count == 0){
                System.out.println("NONE");
            }
            return;
        }

        //和大于整数N时 说明结果集中的数字不满足
        if (sum > n) {
            return;
        }

        //递归 修改结果集中的数据
        for (int i = z; i < n + 1; i++) {
            //设置结果集中的值为当前指向+1
            result[++index] = i;
            //计算和
            sum += i;
            testTwo(i);
            //递归一次 重置指向
            index--;
            //重置和
            sum -= i;

        }
    }

}