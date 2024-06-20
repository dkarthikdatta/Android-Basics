package com.example.myapplication.machinecoding.fileSystem;

public class Main {
    static Directory directory = new Directory("/");

    public static void main(String[] args) {

        String query = "folder1/folder2/folder3";

        String[] path = query.split("/");

        Directory curr = directory;

        for (int i = 0; i < path.length; i++) {
            curr = curr.getDirectory(path[i]);
            if (curr == null) {
                directory.createDirectory(path[i]);
            }
            curr = directory.getDirectory(path[i]);
        }
        File file = new File("myFile", "abc");
        curr.addFile(file);
        System.out.println(curr.getFile("myFile").data);
        System.out.println(curr.getCurrentDirectoryName());

        String query1 = "folder1/folder2/";

        String[] path2 = query.split("/");
        curr = directory;

    }
}
