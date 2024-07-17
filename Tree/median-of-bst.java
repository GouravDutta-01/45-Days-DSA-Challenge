// Question Link :https://www.geeksforgeeks.org/problems/median-of-bst/1
class Tree
{
    public static float findMedian(Node root)
    {
        ArrayList<Integer> list = new ArrayList<>();
        inorder(root, list);
        int n = list.size();
        if(n%2==0){
            return (float)(list.get(n/2-1)+list.get(n/2))/2;
        }
        return list.get(n/2);
    }
    public static void inorder(Node root, ArrayList<Integer> list){
        if(root == null){
            return;
        }
        inorder(root.left, list);
        list.add(root.data);
        inorder(root.right, list);
    }
}