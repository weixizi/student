package com.whx.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.IdType;
import java.util.Date;
import com.baomidou.mybatisplus.annotation.TableId;
import java.io.Serializable;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 
 * </p>
 *
 * @author weixi
 * @since 2020-06-22
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName("t_student")
@ApiModel(value="TStudent对象", description="")
public class TStudent implements Serializable {

    private static final long serialVersionUID=1L;

      @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    private String name;

    private Integer age;

    private Date bir;

    private String phone;

    private String qq;

    private String attr;

    private String starts;

    private String mark;

    private Integer cityid;

    private Integer clazzid;

    private Integer groupid;


}
