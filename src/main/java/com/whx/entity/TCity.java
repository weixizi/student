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
@TableName("t_city")
@ApiModel(value="TCity对象", description="")
public class TCity implements Serializable {

    private static final long serialVersionUID=1L;

      @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    private String name;

    private Date createtime;

    private Integer numbers;


}
