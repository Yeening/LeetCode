* For a char map in Java, create a integer array with size 128, then use the char as index directly.
* Maintain a map of characters, sub the value of character in s whether it's in t or not, if it's not in t, it will be negative.
* Firstly, move end to find a vaild window. Then try to move start to find a short version.
* A template for substring peoblem:
  ```C++
  int findSubstring(string s){
        vector<int> map(128,0);
        int counter; // check whether the substring is valid
        int begin=0, end=0; //two pointers, one point to tail and one  head
        int d; //the length of substring

        for() { /* initialize the hash map here */ }

        while(end<s.size()){

            if(map[s[end++]]-- ?){  /* modify counter here */ }

            while(/* counter condition */){ 
                 
                 /* update d here if finding minimum*/

                //increase begin to make it invalid/valid again
                
                if(map[s[begin++]]++ ?){ /*modify counter here*/ }
            }  

            /* update d here if finding maximum*/
        }
        return d;
    }
    ```
