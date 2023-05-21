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
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String description;

    private Instant createdAt;

    private Instant updatedAt;

    @Override
    public String toString(){
        return String.format("FileItem{id=%d, description='%s', createdAt='%s', updatedAt='%s}",
                id, description, createdAt, updatedAt);
    }

}
