package com.jonas.service;

import com.jonas.entity.Index;

import java.util.List;

/**
 * 【 enter the class description 】
 *
 * @author shenjy 2018/10/25
 */
public interface IndexService {

    boolean batchSave(List<Index> indices);
}
