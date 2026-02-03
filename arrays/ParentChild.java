import java.util.*;

public class ParentChild {
    public static String getParent(String childName, String [][] family){
        for(int i=0 ;i<family.length;i++){
            if(family[i][0].equals(childName))
                return getParent(family[i][1], family);
        }

        return childName;
    }

    public static void buildTree(String parentName,String parentID, String[][] family, ArrayList<ArrayList<String>> tree,int depth){
        int childCount=1;

        for (int i=0;i<family.length;i++){
            if(family[i][1].equals(parentName)){
                String childId= parentID + "." + childCount++;
                tree.add(new ArrayList<>());
                
                tree.get(tree.size()-1).add(childId);
                for(int j=1;j<depth;j++){
                    tree.get(tree.size()-1).add("");
                }
                tree.get(tree.size()-1).add(family[i][0]);

                buildTree(family[i][0], childId, family, tree, depth+1);
            }
        }
    }
    public static void main(String[] args) {

        // String[][] family = {
        //         { "Sam", "John" },
        //         { "Peter", "John" },
        //         { "Kevin", "Sam" },
        //         { "Lily", "Sam" },
        //         { "Mark", "Peter" },
        //         { "Anna", "Tom" },
        //         { "Tom", "Robert" },
        //         { "Jerry", "Robert" }
        // };

        String[][] family = {
            {"Arjun", "Mahesh"},
            {"Ravi", "Mahesh"},
            {"Sita", "Arjun"},
            {"Gopal", "Arjun"},
            {"Meena", "Ravi"},
            {"Karan", "Vijay"}
        };



        ArrayList<ArrayList<String>> tree= new ArrayList<>();
        int parentCount=0;
        
        for(int i=0 ;i< family.length;i++){
            String parent=getParent(family[i][1], family);

            int visited=0;
            for (int j=0;j<tree.size();j++){
                if(tree.get(j).size()>0 && tree.get(j).get(1).equals(parent)){
                    visited=1;
                    break;
                }
            }
            if(visited==0){

                parentCount ++;
                String parentId= parentCount+"";
                tree.add(new ArrayList<>());
                
                tree.get(tree.size()-1).add(parentId);
                tree.get(tree.size()-1).add(parent);
                buildTree(parent, parentId, family, tree, 2);
            }
        }

        for( List<String> row : tree){
            for (String cell: row){
                System.out.printf("%-15s", cell);
            }
            System.out.println();
        }
    }
}
