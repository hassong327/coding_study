class Solution {
    public boolean wordPattern(String pattern, String s) {
        String[] words = s.split(" ");
        HashMap<Character, String> hmap = new HashMap<>();
        HashMap<String, Character> hmap_reversed = new HashMap<>();
        if(pattern.length() != words.length){
            return false;
        }
        for(int i = 0; i < pattern.length(); i++){
            char a = pattern.charAt(i);
            String b = words[i];

            if(hmap.containsKey(a)){
                if(!hmap.get(a).equals(b)){
                    return false;
                }
            }
            else{
                hmap.put(a, b);
            }
            
            
            if(hmap_reversed.containsKey(b)){
                if(!hmap_reversed.get(b).equals(a)){
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