public class EList {
    static int index = 0;
    public static ENode treeBuilder(String s)
    {
        char currentChar = s.charAt(index++);
        ENode node = new ENode(currentChar);
        
        if((currentChar == '+' || currentChar == '-' || currentChar == '*' || currentChar == '%' || currentChar == 'h'))
        {
            node.left = treeBuilder(s);
            node.right = treeBuilder(s);
        }
        
        if(currentChar == 'n' || currentChar == 'f')
        {
            node.left = treeBuilder(s);
            node.right = null;
        }
        
        return node;
        
    }
    
    public static int solveTree(ENode root)
    {
        if(!(root.alpha == '+' || root.alpha == '-' || root.alpha == '*' || root.alpha == '%' || root.alpha == 'h' || root.alpha == 'n' || root.alpha == 'f'))
        {
            return Character.getNumericValue(root.alpha);
        }
        int leftV = solveTree(root.left);
        int rightV = 0;
        if(root.alpha != 'n' && root.alpha != 'f')
        {
        rightV = solveTree(root.right);
        }
        
        if(root.alpha == '+')
        {
            return leftV + rightV;
        }
        if(root.alpha == '-')
        {
            return leftV - rightV;
        }
        if(root.alpha == '*')
        {
            return leftV * rightV;
        }
        if(root.alpha == '%')
        {
            return leftV % rightV;
        }
        if(root.alpha == 'h')
        {
            return (int)Math.sqrt(Math.pow(leftV,2) + Math.pow(rightV,2));
        }
        if(root.alpha == 'n')
        {
            return leftV * -1;
        }
        if(root.alpha == 'f')
        {
            return factorial(leftV);
        }
        
        return 0;
    }
    
    public static int factorial(int n)
    {
        if(n == 0 || n == 1 || n < 0)
        {
            return 1;
        }
        else 
        {
            return n * factorial(n - 1);
        }
    }
    
    public static String printTree(ENode root)
    {
        if(!(root.alpha == '+' || root.alpha == '-' || root.alpha == '*' || root.alpha == '%' || root.alpha == 'h' || root.alpha == 'n' || root.alpha == 'f'))
        {
            return String.valueOf(root.alpha);
        }
        String leftEx = printTree(root.left);
        String rightEx = "";
        if(root.alpha != 'n' && root.alpha != 'f')
        {
        rightEx = printTree(root.right);
        }
        
        return leftEx + root.alpha + rightEx;
    }
}
