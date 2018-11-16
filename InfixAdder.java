import java.util.Arrays;

public class InfixAdder {
    String str;

    public InfixAdder(String string) {
        str = string;
    }

    public double solve() throws Exception
    {
        String newStr = parse();
        Adder add = new Adder(newStr);
        return add.solve();
    }

    public String parse() throws Exception
    {
        String[] exp = new String(str).split("\\s");

        // initializing empty String for result
        String result = new String("");

        // initializing empty stack
        Stack<String> stack = new Stack<>();

        for (int i = 0; i < exp.length; ++i)
        {
            String c = exp[i];

            // If the scanned character is an operand, add it to output.
            if (Character.isLetterOrDigit(c.toCharArray()[0]))
                result += c + " ";

                // If the scanned character is an '(', push it to the stack.
            else if ( c.equals("(") )
                stack.push(c);

                //  If the scanned character is an ')', pop and output from the stack
                // until an '(' is encountered.
            else if ( c.equals(")") )
            {
                while (!stack.isEmpty() && !stack.peek().equals("("))
                    result += stack.pop() + " ";

                if (!stack.isEmpty() && !stack.peek().equals('('))
                    return "Invalid Expression"; // invalid expression
                else
                    stack.pop();
            }
            else // an operator is encountered
            {
                while (!stack.isEmpty() && Prec(c) <= Prec(stack.peek()))
                    result += stack.pop() + " ";
                stack.push(c);
            }

        }

        // pop all the operators from the stack
        while (!stack.isEmpty())
            result += stack.pop() + " ";

        return result;
    }


    public int Prec(String str)
    {
        switch(str)
        {
            case "+":
            case "-":
                return 1;
            case "*":
            case "/":
                return 2;
            case "^":
                return 3;
        }

        return -1;
    }
}
