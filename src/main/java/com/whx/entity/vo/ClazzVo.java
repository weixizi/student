package com.whx.entity.vo;


import lombok.Data;

import java.io.Serializable;

@Data
public class ClazzVo implements Serializable {

    private Integer id;

    private String name;

    private Integer tagid;

    private String tagname;
}
