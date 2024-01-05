public class Runner
{
    public static void main(String[] args)
    {
        String input = "-f5+%h*729n-291";
        //+*-5+27**5-278+-*1234
        EList newFile = new EList();
        ENode root = newFile.treeBuilder(input);
        
        System.out.println("Original input: " + input);
        System.out.println("Expression fixed: " + newFile.printTree(root));
        System.out.println("Tree answer: " + newFile.solveTree(root));
    }
}
