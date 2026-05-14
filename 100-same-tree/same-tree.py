class Solution:
    def isSameTree(self, p, q):
        # If both nodes are null
        if not p and not q:
            return True
        
        # If one is null and the other isn't
        if not p or not q:
            return False
        
        # If values are different
        if p.val != q.val:
            return False
        
        # Check left and right subtrees
        return (self.isSameTree(p.left, q.left) and
                self.isSameTree(p.right, q.right))