package com.whx.entity.vo;

import lombok.Data;

import java.io.Serializable;

@Data
public class GroupVo implements Serializable {
    private Integer id;

    private String name;

    private String content;

    private String clazzname;

    private String tagname;

}
