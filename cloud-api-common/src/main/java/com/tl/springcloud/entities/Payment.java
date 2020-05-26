package com.tl.springcloud.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * <pre>
 * Description
 * @author T-Dragon
 * 2020/4/16 13:47
 * </pre>
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Payment {

	private Long id;

	private String serial;

}
