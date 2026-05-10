// class Solution {
//     public int lengthOfLongestSubstring(String s) {
//         HashSet<Character> hs=new HashSet<>();
//         if(s.length()==0) return 0;
//         int hLen=1;
//         for( int i=0;i<s.length()-1;i++){
//             hs.clear();
//             hs.add(s.charAt(i));
//             int j;
//             for(j=i+1;j<s.length();j++){
//                 if(!hs.add(s.charAt(j))){
//                     break;
//                 }
//             }
//             if(hLen< j-i) hLen=j-i; 
//         }
//         return hLen;
//     }
// }

// class Solution{
//     public int lengthOfLongestSubstring(String s) {
//         HashMap<Character,Integer> hm=new HashMap<>();

//         int l=0,r=0;
//         int maxL=0;
//         for(int i=0;i<s.length();i++){
//             if(hm.get(s.charAt(i))==null || hm.get(s.charAt(i))<l){
//                 hm.put(s.charAt(i),i);
//                 int length= r-l+1;
//                 maxL= length>maxL?length:maxL;
//                 r++;
//             }else {
//                 l=hm.get(s.charAt(i))+1;
//                 hm.put(s.charAt(i),i);
//                 r++;
//             }
//         }
//         return maxL;
//     }
// }


class Solution {
    public int lengthOfLongestSubstring(String s) {
        int[] lastSeen = new int[128]; // ASCII
        for (int i = 0; i < 128; i++) {
            lastSeen[i] = -1;
        }
        int left = 0;
        int maxLength = 0;
        for (int right = 0; right < s.length(); right++) {
            char c = s.charAt(right);
            if (lastSeen[c] >= left) {
                left = lastSeen[c] + 1;
            }
            lastSeen[c] = right;
            maxLength = Math.max(maxLength, right - left + 1);
        }
        return maxLength;
    }
}