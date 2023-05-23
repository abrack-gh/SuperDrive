package com.SuperDrive.SuperDrive.controller;

import com.SuperDrive.SuperDrive.model.FileItem;
import com.SuperDrive.SuperDrive.service.FileItemService;
import com.SuperDrive.SuperDrive.service.FileUploadService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

@Controller
public class FileUploadController {

    public static String uploadDirectory = System.getProperty("user.dir") + "/uploads";

    @Autowired
    private FileItemService fileItemService;

    @Autowired
    FileUploadService fileUploadService;

    @GetMapping("/upload")
    public String showUploadFile(){
        return "upload";
    }

//    @PostMapping("/upload")
//    public String upload(Model model, @RequestParam("file") MultipartFile multipartFile) throws IOException {
//
//        StringBuilder fileNames = new StringBuilder();
//        Path fileNameAndPath = Paths.get(uploadDirectory, multipartFile.getOriginalFilename());
//        fileNames.append(multipartFile.getOriginalFilename());
//        Files.write(fileNameAndPath, multipartFile.getBytes());
//        model.addAttribute("msg", "Uploaded: " + fileNames.toString());
//
//        return "index";
//    }

    @GetMapping("/")
    public String home(Model model){
        List<FileItem> list = fileUploadService.getAllFiles();
        model.addAttribute("list", list);

        return "index";
    }


    @PostMapping("/upload")
    public String fileUpload(@RequestParam("file") MultipartFile file, Model model) throws IOException {

        FileItem fileItem = new FileItem();
        String fileName = file.getOriginalFilename();
        fileItem.setContent(file.getBytes());
        fileItem.setSize(file.getSize());
        fileUploadService.uploadFile(fileItem);
        model.addAttribute("success", "File uploaded.");

        return "index";
    }

}
