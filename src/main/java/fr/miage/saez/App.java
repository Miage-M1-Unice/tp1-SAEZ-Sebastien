package fr.miage.saez;

import java.io.File;
import java.io.FilenameFilter;
import java.io.IOException;
import java.nio.file.FileVisitResult;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.SimpleFileVisitor;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class App {

    /*
      MyFileNameFilter Class
     */
    private  class MyFileNameFilter implements FilenameFilter{

        @Override
        public boolean accept(File dir, String name) {

            //Question 1.c regex
            String maRegex = ".*\\.java";
            Pattern p = Pattern.compile(maRegex);

            File f = new File(dir.getPath()+"/"+name);
            Matcher m = p.matcher(name);
            if(f.isFile()){
                return m.matches();
            }
            return true;
        }
    }

    /*
     *  Methode Exo 1.a
     */
    private void listInDir(File pFile, FilenameFilter filter){
        File[] files = pFile.listFiles(filter);

        for(int x = 0;x< files.length ; x++){
            File currentFile = files[x];
            System.out.println(currentFile.getPath());
            if(currentFile.isDirectory()){
                listInDir(currentFile,filter);
            }
        }
    }

    /*
     *  Methode Exo 1.b - classe anonyme
     */
    private void listFilesEx2(File pFile) throws IOException {
            Files.walkFileTree(pFile.toPath(), new SimpleFileVisitor<Path>(){
                @Override
                public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
                    System.out.println(file);
                    return super.visitFile(file,attrs);
                }
            });
    }

    public static void main( String[] args ) {
        App app = new App();
        File f = new File(".");

        final String[] extensions = {".java",".class"};

        FilenameFilter filterExterne = new FileNameFilter();
        MyFileNameFilter filterInterne = app.new MyFileNameFilter();

        FilenameFilter filterAnonyme = new FilenameFilter() {
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

        //Question 1.a
        app.listInDir(f,filterInterne);

        //Question 1.b
        /*try {
            app.listFilesEx2(f);
        } catch (IOException e) {
            e.printStackTrace();
        }*/
    }


}
