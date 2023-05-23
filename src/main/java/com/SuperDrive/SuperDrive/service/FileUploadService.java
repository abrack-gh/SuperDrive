package com.SuperDrive.SuperDrive.service;

import com.SuperDrive.SuperDrive.model.FileItem;
import com.SuperDrive.SuperDrive.repositories.FileItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.List;

@Service
public class FileUploadService {

    @Autowired
    private FileItemRepository fileItemRepository;

    public FileItem uploadFile(FileItem fileItem) {
        return fileItemRepository.save(fileItem);
    }

    public List<FileItem> getAllFiles() {
        return fileItemRepository.findAll();

    }






}
