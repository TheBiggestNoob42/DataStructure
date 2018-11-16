/*
* This program takes in a string and uses postfix addition to add numbers
*
* */
public class Adder {
    String[] str;
    Stack<Double> stack;

    public Adder(String string) {
        str = string.split("\\s");
        stack = new Stack<>();
    }

    public double solve() {
        for(int i = 0; i < str.length; i++) {
            if (isNumeric(str[i])) {
                stack.push(Double.parseDouble(str[i]));
            } else {
                double numb, numb2, numb3;
                try {
                    switch (str[i]) {
                        case "+":
                            numb = stack.pop();
                            numb2 = stack.pop();
                            numb3 = numb2 + numb;
                            stack.push(numb3);

                            break;
                        case "-":
                            numb = stack.pop();
                            numb2 = stack.pop();
                            numb3 = numb2 - numb;
                            stack.push(numb3);

                            break;
                        case "*":
                            numb = stack.pop();
                            numb2 = stack.pop();
                            numb3 = numb2 * numb;
                            stack.push(numb3);

                            break;
                        case "/":
                            numb = stack.pop();
                            numb2 = stack.pop();
                            numb3 = numb2 / numb;
                            stack.push(numb3);

                            break;
                        case "^":
                            numb = stack.pop();
                            numb2 = stack.pop();
                            numb3 = Math.pow(numb2, numb);
                            stack.push(numb3);
                            break;
                    }
                } catch (Exception ex) {
                    System.out.println("\n\n\nOperands won't work!!\n\n\n");
                }
            }

        }
        try {
            return stack.pop();
        } catch(Exception ex) {
            System.out.println("Nothing in stack");
            return -1.0;
        }
    }

    public boolean isNumeric(String str) {
        try {
            double d = Double.parseDouble(str);
        }catch(Exception ex){
            return false;
        }
        return true;
    }
}
