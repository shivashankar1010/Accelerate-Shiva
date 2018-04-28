package com.homeoffice.assessment.files;

import org.apache.commons.io.FileUtils;
import org.apache.commons.io.FilenameUtils;

import java.io.File;
import java.io.IOException;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class DirectoryScan {





    public File[] getAllFilesInADirectory(String directoryName){
        File directory = new File (System.getProperty("user.dir")+"//"+directoryName);
        File[] allFilesInDirectory = directory.listFiles();
        return allFilesInDirectory;
    }

    public String getMimeTypeOfAFile(File file){
        if(file == null){
            throw new IllegalArgumentException("File Cannot Be Null");
        }
        String mimeType = null;
        MimeTypeDetector mpd = new MimeTypeDetector();
        try {
           mimeType = mpd.probeContentType(Paths.get(file.getAbsolutePath()));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return mimeType;
    }

    public String getFileSize(File file){
        if(file == null){
            throw new IllegalArgumentException("File Cannot Be Null");
        }
        return FileUtils.byteCountToDisplaySize(file.length());
    }

    public String getFileExtension(File file){
        if(file == null){
            throw new IllegalArgumentException("File Cannot Be Null");
        }
        return FilenameUtils.getExtension(file.getName());
    }

    public String getFileName(File file){
        if(file == null){
            throw new IllegalArgumentException("File Cannot Be Null");
        }
        return file.getName();
    }


    public List<File> getFilesBasedOnMimeType(String directoryName, String mimeType){
        File directory = new File (System.getProperty("user.dir")+"//"+directoryName);
        File[] allFilesInDirectory = directory.listFiles();
        List<File> filesOfSupportedMimeType = new ArrayList<>();

        for(File file : allFilesInDirectory){
            String mimeTypeOfCurrentFile = getMimeTypeOfAFile(file);
            if(mimeTypeOfCurrentFile.contains(mimeType)){
                filesOfSupportedMimeType.add(file);
            }
        }
        return filesOfSupportedMimeType;
    }

    public static void main (String[] args) {

        DirectoryScan ds = new DirectoryScan();
        File[] allFiles = ds.getAllFilesInADirectory("Files");
        for (File file: allFiles){
            System.out.println("File Name is "+ds.getFileName(file));
            System.out.println("File Size is "+ds.getFileSize(file));
            System.out.println("File Extension is "+ ds.getFileExtension(file));
            System.out.println("File Mime Type is "+ ds.getMimeTypeOfAFile(file));
        }

        List<File> filesOfMimeFormat = ds.getFilesBasedOnMimeType("Files", "sheet");
        for (File file: filesOfMimeFormat){
            System.out.println("PDF File Name is "+file.getName());
        }




    }
}
