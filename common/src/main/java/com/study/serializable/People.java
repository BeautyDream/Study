package com.study.serializable;

import lombok.Data;
import lombok.ToString;

import java.io.Serializable;

/**
 * @Auther: LiaoPeng
 * @Date: 2019/5/12
 */
@Data
@ToString
public class People implements Serializable{

    private static final long serialVersionUID = 1L;

    private Integer id;
    private String name;
    private Integer age;

    private String sex;

}
