package stack;


import java.util.Stack;

public class ReversePolishNotationTest {

    public static void main(String[] args) {
        //中缀表达式 3*（17-15）+18/6 的逆波兰表达式如下 6+3=9
        String[] notation = {"3", "17", "15", "-", "*", "18", "6", "/", "+"};
        int result = caculate(notation);
        System.out.println("逆波兰表达式的结果为：" + result);
    }

    /**
     * @param notaion 逆波兰表达式的数组表示方式
     * @return 逆波兰表达式的计算结果
     */
    public static int caculate(String[] notaion) {
        //1.定义一个栈，用来存储操作数
        Stack<Integer> operator = new Stack<>();
        //2.从左往右遍历逆波兰表达式，得到每一个元素
        for (int i = 0; i < notaion.length; i++) {
            String curr = notaion[i];
            //3.判断当前元素是运算符还是操作数
            Integer o1;
            Integer o2;
            int result;
            switch (curr) {
                case "+":
                    //4.运算符，从栈中弹出两个操作数，完成运算，运算完的结果再压入栈中
                    o1 = operator.pop();
                    o2 = operator.pop();
                    result = o2 + o1;
                    operator.push(result);
                    break;
                case "-":
                    //4.运算符，从栈中弹出两个操作数，完成运算，运算完的结果再压入栈中
                    o1 = operator.pop();
                    o2 = operator.pop();
                    result = o2 - o1;
                    operator.push(result);
                    break;
                case "*":
                    //4.运算符，从栈中弹出两个操作数，完成运算，运算完的结果再压入栈中
                    o1 = operator.pop();
                    o2 = operator.pop();
                    result = o2 * o1;
                    operator.push(result);
                    break;
                case "/":
                    //4.运算符，从栈中弹出两个操作数，完成运算，运算完的结果再压入栈中
                    o1 = operator.pop();
                    o2 = operator.pop();
                    result = o2 / o1;
                    operator.push(result);

                    break;
                default:
                    //5.操作数，把该操作数放入到栈中；
                    operator.push(Integer.parseInt(curr));
                    break;
            }

        }


        //6.得到栈中最后一个元素，就是逆波兰表达式的结果
        return operator.pop();
    }

}
