package com.atguigu.springcloud.repository.domain;

import lombok.Data;
import lombok.experimental.Accessors;

import java.io.Serializable;

/**
 * (Payment)实体类
 *
 * @author makejava
 * @since 2020-07-18 10:25:40
 */
@Data
@Accessors(chain = true)
public class PaymentDomain implements Serializable {
    private static final long serialVersionUID = 7802256939090885167L;
    /**
     * id
     */
    private Long id;

    private String serial;
}