package com.example.myapplication.machinecoding.fileSystem;

import java.util.HashMap;

public class Directory {
    private final HashMap<String, Directory> directories;
    private final HashMap<String, File> files;
    private final String directoryName;

    public Directory(String directoryName) {
        this.directoryName = directoryName;
        this.directories = new HashMap<>();
        this.files = new HashMap<>();
    }


    public void createDirectory(String name) {
        directories.put(name, new Directory(name));
    }

    public Directory getDirectory(String name) {
        if (directories.get(name) != null) {
            System.out.println("current directory = " + name);
            return directories.get(name);
        }
        System.out.println("current directory = " + null);
        return null;
    }

    public HashMap<String, Directory> getDirectories(){
        return directories;
    }
    public void addFile(File file) {
        files.put(file.name, file);
    }

    public File getFile(String name) {
        if (files.get(name) != null && files.get(name) != null) {
            return files.get(name);
        }
        return null;
    }

    public String getCurrentDirectoryName() {
        return directoryName;
    }
}
