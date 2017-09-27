package corcedclosures;

import coercedclosures.ListDirectories;
import org.junit.Test;

import java.io.File;

import static org.junit.Assert.assertTrue;

public class ListDirectoriesTest {
    private ListDirectories ld = new ListDirectories();

    @Test
    public void testListDirectoryNames() {
        String[] dirs = ld.listDirectoryNames("/");
        for (String name : dirs) {
            System.out.println(name);
            assertTrue(new File(name).isDirectory());
        }
    }
}
