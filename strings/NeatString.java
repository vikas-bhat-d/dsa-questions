import java.util.*;
public class NeatString {
    public static void main(String[] args) {
        StringBuilder sb= new StringBuilder("aAAaBbBBc");

        HashMap<Character, Integer> hm= new HashMap<Character,Integer>();
        int CL= 3;
        int CU= 2;

        for(int i=0;i<sb.length();i++){
            if(hm.containsKey(Character.toLowerCase(sb.charAt(i)))){
                continue;
            }
            int lc=0;
            int uc=0;

            for(int j=i;j<sb.length();j++){

                if(Character.toLowerCase(sb.charAt(j))== Character.toLowerCase(sb.charAt(i))){
                    if(Character.isLowerCase(sb.charAt(j))){
                        lc++;
                    }else{
                        uc++;
                    }
                }
            }
            if( lc*CU > uc*CL){
                hm.put(Character.toLowerCase(sb.charAt(i)), -1);
            }else if (uc*CL >= lc*CU ){
                hm.put(Character.toLowerCase(sb.charAt(i)), 1);
            }
        }

        System.out.println(hm);

        for( int i=0;i<sb.length();i++){
            char ch= sb.charAt(i);

            if( hm.get(Character.toLowerCase(ch))>0){
                sb.setCharAt(i, Character.toUpperCase(ch));
            }else{
                sb.setCharAt(i, Character.toLowerCase(ch));
            }
        }

        System.out.println(sb);
    }
}
