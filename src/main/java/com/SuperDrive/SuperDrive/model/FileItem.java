package com.SuperDrive.SuperDrive.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.time.Instant;

@Getter
@Setter
@Entity
@Table(name = "file_items")
public class FileItem implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String profilePicture;

    private Long size;

    private byte[] content;

    private Instant createdAt;

    private Instant updatedAt;

}
