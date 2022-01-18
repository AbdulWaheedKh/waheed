package org.waheed.java.model;

import java.io.Serializable;

import lombok.Data;

@Data
public class GenericModel implements Serializable {

    private Long ID;
    private Boolean Deleted;
}
