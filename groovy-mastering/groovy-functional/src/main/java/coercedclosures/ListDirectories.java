package coercedclosures;

import java.io.File;

public class ListDirectories {
    public String[] listDirectoryNames(String root) {
        return new File(root).list((file, s) -> new File(s).isDirectory());
    }
}
