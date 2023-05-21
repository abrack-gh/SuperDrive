package com.SuperDrive.SuperDrive.service;

import com.SuperDrive.SuperDrive.model.FileItem;
import com.SuperDrive.SuperDrive.repositories.FileItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.File;
import java.sql.Timestamp;
import java.time.Instant;
import java.util.Optional;

@Service
public class FileItemService {

    @Autowired
    private FileItemRepository fileItemRepository;

    public Iterable<FileItem> getAll(){
        return fileItemRepository.findAll();
    }

    public Optional<FileItem> getById(Long id){
        return fileItemRepository.findById(id);
    }

    public FileItem save(FileItem fileItem){
        if(fileItem.getId() == null){
            fileItem.setCreatedAt(Instant.now());
        }

        fileItem.setUpdatedAt(Instant.now());

        return fileItemRepository.save(fileItem);
    }

    public void delete(FileItem fileItem){
        fileItemRepository.delete(fileItem);
    }

}
