package lc71_SimplifyPath;

import java.util.ArrayList;
import java.util.List;

/*
Given an absolute path for a file (Unix-style), simplify it. Or in other words, convert it to the canonical path.

In a UNIX-style file system, a period . refers to the current directory. Furthermore, a double period .. moves the
directory up a level.

Note that the returned canonical path must always begin with a slash /, and there must be only a single slash / between
two directory names. The last directory name (if it exists) must not end with a trailing /. Also, the canonical path
must be the shortest string representing the absolute path.
 */
public class Solution {
    private int read(String path, int start) {
        int end = start+1;
        for (; end < path.length() && path.charAt(end) != '/'; end++);
        return end;
    }
    public String simplifyPath(String path) {
        // "/a/../../b/../c//.//"
        //  01234567890123456789
        // list = "c"
        // start = 19
        // end = 20

        List<String> result = new ArrayList<>();
        int start = 0;

        while (start < path.length()) {
            int end = read(path, start);
            if ((end == start + 1) ||  // "/$"
                    (end == start + 2 && path.charAt(end-1) == '.') // "/./"
            ) {
                // do nothing
            } else if (end == start + 3 && path.charAt(start+1) == '.' && path.charAt(start+2) == '.') {  // "/../"
                if (result.size() > 0)
                    result.remove(result.size() - 1);
            } else { // regular path item
                result.add(path.substring(start+1, end));
            }
            start = end;
        }
        StringBuilder sb = new StringBuilder();

        for (String s : result) {
            sb.append('/');
            sb.append(s);
        }
        if (result.size() == 0) {
            sb.append('/');
        }
        return sb.toString();
    }
}