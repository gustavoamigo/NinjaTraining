package fb;

public class Codec {
  public static class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }

      public TreeNode(int val, TreeNode left, TreeNode right) {
          this.val = val;
          this.left = left;
          this.right = right;
      }
  }


    // Encodes a tree to a single string.
    /*
       1
      2
       3
       [1,[2,null,[3,null,null]],null]
    */
    public String serialize(TreeNode root) {
        String left = root.left != null ? serialize(root.left) : "null";
        String right = root.right != null ? serialize(root.right) : "null";
        return "[" + root.val + "," + left + "," + right + "]";
    }

    // [1,[2,null,[3,null,null]],null]
    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if(data.equals("null")) {
            return null;
        } else {
            StringBuffer valBuff = new StringBuffer();
            int i = 1;
            char ch = '-';
            do {
                ch = data.charAt(i);
                if(ch != ',') valBuff.append(ch);
                i++;
            } while (ch != ',' );

            int val = Integer.parseInt(valBuff.toString());

            StringBuffer leftBuff = new StringBuffer();
            if(data.substring(i, i + 4).equals("null")) {
                leftBuff.append("null");
                i += 4;
            } else {
                int balance = 0;
                do {
                    ch = data.charAt(i);
                    leftBuff.append(ch);
                    if(ch == '[') {
                        balance ++;
                    }
                    if(ch == ']') {
                        balance --;
                    }
                    i++;
                } while (balance > 0);
            }

            i++; // skip comma

            StringBuffer rightBuff = new StringBuffer();
            if(data.substring(i, i + 4).equals("null")) {
                rightBuff.append("null");
                i += 4;
            } else {
                int balance=0;
                do {
                    ch = data.charAt(i);
                    rightBuff.append(ch);
                    if(ch == '[') {
                        balance ++;
                    }
                    if(ch == ']') {
                        balance --;
                    }
                    i++;
                } while (balance > 0);
            }

            return new TreeNode(val, deserialize(leftBuff.toString()), deserialize(rightBuff.toString()));
        }
    }

    public static void main(String[] args) {
        Codec codec = new Codec();
        System.out.println(codec.serialize(new TreeNode(1, null, null)));
       TreeNode node = codec.deserialize("[1,[2,null,null],null]");
        System.out.println(codec.serialize(node));
    }
}