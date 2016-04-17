public class NumArray {

    class TreeNode {
        int val, l, r;
        TreeNode left, right;
        // l, r: range
        TreeNode(int val, int l, int r) {
            this.val = val;
            this.l = l;
            this.r = r;
        }
    }
    
    TreeNode root;
    public TreeNode buildSegmentTree(int[] nums, int l, int r) {
        if(l>r) {
            return null;
        }
        
        if(l==r) {
            return new TreeNode(nums[l], l, r);
        }
        
        int m = l+(r-l)/2;
        TreeNode left = buildSegmentTree(nums, l, m);
        TreeNode right = buildSegmentTree(nums, m+1, r);
        int sum = 0;
        if(left!=null) {
            sum+=left.val;
        }
        if(right!=null) {
            sum+=right.val;
        }
        TreeNode root = new TreeNode(sum, l, r);
        root.left = left;
        root.right = right;
        return root;
    }

    public NumArray(int[] nums) {
        root = buildSegmentTree(nums, 0, nums.length-1);
    }

    void update(int i, int val) {
        updateRec(root, i,  val);
    }
    
    private int updateRec(TreeNode root, int i, int val) {
        if(root.l==i && root.r==i) {
            root.val = val;
            return val;
        }
        
        if(root.l>i || root.r<i) return root.val;
        int retSum = 0;
        if(root.left!=null) {
            retSum+=updateRec(root.left, i, val);
        }
        if(root.right!=null) {
            retSum+=updateRec(root.right, i, val);
        }
        root.val = retSum;
        return retSum;
        
    }

    public int sumRange(int i, int j) {
        return sumRangeRec(root, i, j);
    }
    
    private int sumRangeRec(TreeNode root, int i, int j) {
        int l = root.l;
        int r = root.r;
        if(l>=i && r<=j) return root.val;
        if(j<l || i>r) return 0;
        
        int resSum=0;
        if(root.left!=null) {
            resSum+=sumRangeRec(root.left, i, j);
        }
        if(root.right!=null) {
            resSum+=sumRangeRec(root.right, i, j);
        }
        return resSum;
    }
}
