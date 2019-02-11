package fr.miage.saez;

import java.io.File;
import java.io.FilenameFilter;



/**
 * Hello world!
 *
 */
public class App {

    private  class MyFileNameFilter implements FilenameFilter{

        @Override
        public boolean accept(File dir, String name) {
            File f = new File(dir.getPath()+"/"+name);
            if(f.isFile()){
                return name.endsWith(".java");
            }
            return true;
        }
    }

    private void listInDir(File pFile, FilenameFilter filter){
        File[] files = pFile.listFiles(filter);

        for(int x = 0;x< files.length ; x++){
            File currentFile = files[x];
            System.out.println(currentFile.getName());
            if(currentFile.isDirectory()){
                listInDir(currentFile,filter);
            }
        }
    }

    public static void main( String[] args ) {
        App app = new App();
        File f = new File(".");
        final String[] extensions = {".java",".class"};

        FilenameFilter filter1 = new FilenameFilter() {
            @Override
            public boolean accept(File dir, String name) {
                boolean isntFilter = true;
                File f = new File(dir.getPath()+"/"+name);

                if(f.isFile()){
                    isntFilter = false;
                    for(String ext : extensions ){
                        if(name.endsWith(ext)){
                            isntFilter = true;
                        }
                    }
                }
                return isntFilter;
            }
        };
        FilenameFilter filter2 = new FileNameFilter();
        MyFileNameFilter filter3 = app.new MyFileNameFilter();

        app.listInDir(f,filter1);

        }


}
