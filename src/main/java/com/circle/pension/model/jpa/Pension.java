package com.circle.pension.model.jpa;

import lombok.*;

import javax.persistence.*;

@Entity
@Table(name = "area_month_pension")
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Pension {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private int id;

    /**
     * 县级Code
     */
    @Column(name = "area_code")
    private String areaCode;

    /**
     * 缴纳养老保险的月份
     */
    @Column(name = "month")
    private String dateMonth;

    /**
     * 缴纳养老保险这个月的金额数目
     */
    @Column(name = "pension_sum")
    private Long pensionSum;

}
