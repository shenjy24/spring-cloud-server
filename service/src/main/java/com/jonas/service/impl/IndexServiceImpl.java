package com.jonas.service.impl;

import com.baomidou.mybatisplus.core.toolkit.CollectionUtils;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.jonas.entity.Index;
import com.jonas.mapper.IndexMapper;
import com.jonas.service.IndexService;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 【 enter the class description 】
 *
 * @author shenjy 2018/10/25
 */
@Service
public class IndexServiceImpl extends ServiceImpl<IndexMapper, Index> implements IndexService {

    @Override
    public boolean batchSave(List<Index> indices) {
        if (CollectionUtils.isEmpty(indices)) {
            return false;
        }

        return this.saveBatch(indices);
    }
}
