import java.util.*;


class Solution {
    public boolean isIsomorphic(String s, String t) {
        HashMap<Character, Character> hmap = new HashMap<>();
        HashMap<Character, Character> hmap_reversed = new HashMap<>();
        for(int i = 0; i < s.length(); i++){
            char a = s.charAt(i);
            char b = t.charAt(i);

            if(hmap.containsKey(a)){
                if(hmap.get(a) != b){
                    return false;
                }
            }
            else{
                hmap.put(a, b);
            }

            if(hmap_reversed.containsKey(b)){
                if(hmap_reversed.get(b) != a){
                    return false;
                }
            }
            else{
                hmap_reversed.put(b, a);
            }
        }
        return true;
    }
}