# Basic Calculator
## Reverse-Polish notation
* 中缀表达式转换为后缀表达式   
  你需要设定一个栈SOP,和一个线性表L。SOP用于临时存储运算符和左括号分界符( ，L用于存储后缀表达式。   
  * 遍历原始表达式中的每一个表达式元素   
    * 如果是操作数，则直接追加到 L中。只有 运算符 或者 分界符（ 才可以存放到 栈SOP中
    * 如果是分界符
      * 如果是左括号(， 则 直接压入SOP，等待下一个最近的 右括号 与之配对。
      * 如果是右括号），则说明有一对括号已经配对(在表达式输入无误的情况下)。不将它压栈，丢弃它，然后从SOP中出栈，得到元素e，将e依次追加到L里。一直循环，直到出栈元素e 是 左括号 ( ，同样丢弃他。
    * 如果是运算符（用op1表示）
      * 如果SOP栈顶元素（用op2表示） 不是运算符，则二者没有可比性，则直接将此运算符op1压栈。 例如栈顶是左括号 ( ，或者栈为空。
      * 如果SOP栈顶元素（用op2表示） 是运算符 ，则比较op1和 op2的优先级。如果op1 > op2 ，则直接将此运算符op1压栈。如果不满足op1 > op2，则将op2出栈，并追加到L，重复步骤3。
  也就是说，如果在SOP栈中，有2个相邻的元素都是运算符，则他们必须满足：下层运算符的优先级一定小于上层元素的优先级，才能相邻。   
  最后，如果SOP中还有元素，则依次弹出追加到L后，就得到了后缀表达式。
* Calculate reverse-Polish notation
```
function suffixToResult(suffix_expression)
{
    for each element in suffix_expression
    {
        if(element 是 操作数)
        {
            scalc.push(element)
        }
        else if(element 是运算符)
        {
            #从栈中弹出2个操作数 num1 和 num2 。注意：后弹出的num2是第一操作数，num1是第二操作数 。
            #因为这里考虑的都是二元运算符，因此需要弹2个元素出来进行运算。
            num1 = scalc.pop()
            num2 = scalc.pop()

            #使用element代表的运算符完成 num2 和 num1 的计算，产生临时结果 temp_value
            temp_value = num2 【element的运算符: +  ,-  ,* , / 】 num1

            #将temp_value压栈
            scalc.push(temp_value)   
        }

        #如果一切正常，最后栈scalc中仅仅只有一个元素，这个元素就是最终的结果
        return sclac.pop()
    }
}
```
## Iterative
1. digit: it should be one digit from the current number
2. '+': number is over, we can add the previous number and start a new number
3. '-': same as above
4. '(': push the previous result and the sign into the stack, set result to 0, just calculate the new result within the parenthesis.
5. ')': pop out the top two numbers from stack, first one is the sign before this pair of parenthesis, second is the temporary result before this pair of parenthesis. We add them together.
