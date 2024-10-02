package com.vds.huylq33.springbootdemo.model;

import java.io.Serializable;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@ToString
public class Journal implements Serializable {

    private Long id;

    private String title;

    private String summary;

    public Journal(Long id, String title, String summary) {
        this.id = id;
        this.title = title;
        this.summary = summary;
    }
}
