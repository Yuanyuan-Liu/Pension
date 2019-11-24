package com.circle.pension.model.jpa;

import lombok.*;

import javax.persistence.*;

@Entity
@Table(name = "area")
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Area {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    /**
     * 地区编码，包含了市的编码和县的编码
     */
    @Column(name = "area_code")
    private String code;

    /**
     * 地区的名称
     */
    @Column(name = "area_name")
    private String name;

    /**
     * 地区级别，1表示市，2表示县
     */
    @Column(name = "area_level")
    private int level;

    /**
     * 表示上一级ID，显得上一级ID表示市，具体数字1-9；市的上一级ID统一0
     */
    @Column(name = "parent_id")
    private int parentId;
}