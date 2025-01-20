package com.sondev.jdbc_template.model;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.FieldDefaults;

import java.io.Serializable;

@Getter
@Setter
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Category implements Serializable {
    static final long serialVersionUID= 1L;
    Long id;
    String name;
}
