package SearchFiles;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class SearchFileInFolders {
    private List<String> Path = new ArrayList<>();

    public SearchFileInFolders(String path){
        searchFile(path);
    }

    private void searchFile(String path){

        File file = new File(path);

        if (file.isDirectory()){
            scanFolder(file);
        } else {
            System.out.println("Ошибка! Данный путь не является директорией!");
        }

    }

    private void scanFolder(File file){
        if (file.isFile()){
            //System.out.println(file.getName() + " -> " + file.getPath());
            Path.add(file.getPath());
        }

        if (file.isDirectory()){
            File[] folder = file.listFiles();
            for (File files : folder){
                    scanFolder(files);
            }
        }
    }
}
