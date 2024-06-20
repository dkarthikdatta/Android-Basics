package com.example.myapplication.machinecoding.fileSystem;

import java.util.*;

class InMemoryFileSystem {
    private class File {
        String name;
        StringBuilder content;

        public File(String name, String content) {
            this.name = name;
            this.content = new StringBuilder(content);
        }
    }

    private class Directory {
        String name;
        Map<String, Directory> directories;
        Map<String, File> files;

        public Directory(String name) {
            this.name = name;
            this.directories = new TreeMap<>();
            this.files = new TreeMap<>();
        }
    }

    private Directory root;

    public InMemoryFileSystem() {
        root = new Directory("/");
    }

    public void mkdir(String path) {
        String[] dirs = path.split("/");
        Directory curr = root;

        for (String dir : dirs) {
            if (dir.isEmpty()) continue;
            if (!curr.directories.containsKey(dir)) {
                curr.directories.put(dir, new Directory(dir));
            }
            curr = curr.directories.get(dir);
        }
    }

    public List<String> ls(String path) {
        String[] dirs = path.split("/");
        Directory curr = root;

        for (String dir : dirs) {
            if (dir.isEmpty()) continue;
            if (!curr.directories.containsKey(dir)) {
                return new ArrayList<>(Collections.singletonList(dir));
            }
            curr = curr.directories.get(dir);
        }

        List<String> result = new ArrayList<>();
        result.addAll(curr.directories.keySet());
        result.addAll(curr.files.keySet());
        Collections.sort(result);
        return result;
    }

    public void addContentToFile(String filePath, String content) {
        String[] dirs = filePath.split("/");
        String fileName = dirs[dirs.length - 1];
        StringBuilder fileContent = new StringBuilder(content);

        Directory curr = root;
        for (int i = 1; i < dirs.length - 1; i++) {
            if (!curr.directories.containsKey(dirs[i])) {
                mkdir(curr.name + "/" + dirs[i]);
            }
            curr = curr.directories.get(dirs[i]);
        }

        if (curr.files.containsKey(fileName)) {
            curr.files.get(fileName).content.append(content);
        } else {
            curr.files.put(fileName, new File(fileName, content));
        }
    }

    public String readContentFromFile(String filePath) {
        String[] dirs = filePath.split("/");
        String fileName = dirs[dirs.length - 1];

        Directory curr = root;
        for (int i = 1; i < dirs.length - 1; i++) {
            if (!curr.directories.containsKey(dirs[i])) {
                return ""; // Directory not found
            }
            curr = curr.directories.get(dirs[i]);
        }

        if (curr.files.containsKey(fileName)) {
            return curr.files.get(fileName).content.toString();
        } else {
            return ""; // File not found
        }
    }
}

public class MainClass {
    public static void main(String[] args) {
        InMemoryFileSystem fs = new InMemoryFileSystem();
        fs.mkdir("/dir1");
        fs.mkdir("/dir2");
        fs.addContentToFile("/file1.txt", "Hello");
        fs.addContentToFile("/file2.txt", "World");
        fs.addContentToFile("/dir1/file3.txt", "This is a directory");
        System.out.println(fs.ls("/"));
        System.out.println(fs.readContentFromFile("/file1.txt"));
        System.out.println(fs.readContentFromFile("/file2.txt"));
        System.out.println(fs.ls("/dir1"));
        System.out.println(fs.readContentFromFile("/dir1/file3.txt"));
    }
}