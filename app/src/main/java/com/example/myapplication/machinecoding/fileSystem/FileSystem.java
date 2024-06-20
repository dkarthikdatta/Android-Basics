package com.example.myapplication.machinecoding.fileSystem;

public class FileSystem {
    private Directory root;
    public FileSystem(){
        root = new Directory("/");
    }

    public void mkDir(String path){
        Directory curr = root;

        String[] dirs = path.split("/");
        for(String dir: dirs){
            if(!curr.getDirectories().containsKey(dir)){
                curr.getDirectories().put(dir, new Directory(dir));
            }
            curr = curr.getDirectories().get(dir);
        }
    }

}
