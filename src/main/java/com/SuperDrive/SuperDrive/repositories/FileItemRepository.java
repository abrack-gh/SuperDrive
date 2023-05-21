package com.SuperDrive.SuperDrive.repositories;

import com.SuperDrive.SuperDrive.model.FileItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FileItemRepository extends JpaRepository<FileItem, Long> {


}
