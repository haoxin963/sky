package com.github.sky.recordService.service.impl;

import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.github.sky.common.util.IdWorker;
import com.github.sky.common.util.Query;
import com.github.sky.common.util.exception.RRException;
import com.github.sky.common.vo.RecordVO;
import com.github.sky.common.vo.RepairProjectVO;
import com.github.sky.common.vo.VehiclePartsVO;
import com.github.sky.recordService.entity.RepairRecord;
import com.github.sky.recordService.entity.RrRepairItem;
import com.github.sky.recordService.entity.RrRepairPart;
import com.github.sky.recordService.entity.RrRepairRecord;
import com.github.sky.recordService.mapper.RrRepairRecordMapper;
import com.github.sky.recordService.service.IRrRepairItemService;
import com.github.sky.recordService.service.IRrRepairPartService;
import com.github.sky.recordService.service.IRrRepairRecordService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;


/**
 * @Auther: haoxin
 * @Date: 2018-10-11 15:15
 * @Description:维修记录服务实现类
 */
@Service
@Slf4j
public class RrRepairRecordServiceImpl extends ServiceImpl<RrRepairRecordMapper, RrRepairRecord> implements IRrRepairRecordService {

    @Autowired
    private RrRepairRecordMapper rrRepairRecordMapper;

    @Autowired
    private IRrRepairItemService rrRepairItemService;

    @Autowired
    private IRrRepairPartService rrRepairPartService;

    @Autowired
    private RabbitTemplate rabbitTemplate;

    @Override
    @Transactional
    public boolean add(RecordVO record, Long maintId) {
        try {
            RepairRecord repairRecord = this.getRepairRecord(record,maintId);
            rrRepairRecordMapper.insert(repairRecord.getRrRepairRecord());
            rrRepairItemService.addRepairProjectBatch(repairRecord.getRrRepairItems());
            rrRepairPartService.addVehiclePartsBatch(repairRecord.getRrRepairParts());
        } catch (Exception e) {
            e.printStackTrace();
            throw new RRException(e.getMessage());
        }
        return true;
    }

    private RepairRecord getRepairRecord(RecordVO record,Long maintId){
        if(record == null) {
            throw new RRException("维修记录为空");
        }
        if(maintId == null) {
            throw new RRException("获取当前企业失败");
        }
        RepairRecord repairRecord = new RepairRecord();
        IdWorker idWorker = new IdWorker(0, 0);
        RrRepairRecord rrRepairRecord = new RrRepairRecord();
        String recordId = String.valueOf(idWorker.nextId());
        rrRepairRecord.setRecordId(recordId);
        rrRepairRecord.setMaintId(maintId);
        rrRepairRecord.setMaintName(record.getCompanyname());
        rrRepairRecord.setVin(record.getVin());
        rrRepairRecord.setCostlistcode(record.getCostlistcode());
        rrRepairRecord.setFaultdescription(record.getFaultdescription());
        rrRepairRecord.setVehicleplatenumber(record.getVehicleplatenumber());
        rrRepairRecord.setRepairdate(record.getRepairdate());
        rrRepairRecord.setRepairrmileate(record.getRepairmileage());
        rrRepairRecord.setSettledate(record.getSettledate());
        rrRepairRecord.setCreateDate(new Date());
        rrRepairRecord.setDelFlag("0");
        repairRecord.setRrRepairRecord(rrRepairRecord);

        List<RepairProjectVO> repairProjectVOs = record.getRepairprojectlist();
        if(repairProjectVOs != null) {
            List<RrRepairItem> itemList = new ArrayList<>();
            for (RepairProjectVO repairProjectVO : repairProjectVOs) {
                RrRepairItem rrRepairItem = new RrRepairItem();
                rrRepairItem.setItemId(String.valueOf(idWorker.nextId()));
                rrRepairItem.setRecordId(recordId);
                rrRepairItem.setMaintId(maintId);
                rrRepairItem.setWorkinghours(repairProjectVO.getWorkinghours());
                rrRepairItem.setRepairproject(repairProjectVO.getRepairproject());
                rrRepairItem.setCreateDate(new Date());
                rrRepairItem.setDelFlag("0");
                itemList.add(rrRepairItem);
            }
            repairRecord.setRrRepairItems(itemList);
        }

        List<VehiclePartsVO> vehiclePartsVOs = record.getVehiclepartslist();
        if(vehiclePartsVOs != null) {
            List<RrRepairPart> partsList = new ArrayList<>();
            for(VehiclePartsVO vehiclePartsVO : vehiclePartsVOs) {
                RrRepairPart rrRepairPart = new RrRepairPart();
                rrRepairPart.setPartId(String.valueOf(idWorker.nextId()));
                rrRepairPart.setRecordId(recordId);
                rrRepairPart.setMaintId(maintId);
                rrRepairPart.setPartscode(vehiclePartsVO.getPartscode());
                rrRepairPart.setPartsname(vehiclePartsVO.getPartsname());
                rrRepairPart.setPartsquantity(vehiclePartsVO.getPartsquantity());
                rrRepairPart.setCreateDate(new Date());
                rrRepairPart.setDelFlag("0");
                partsList.add(rrRepairPart);
            }
            repairRecord.setRrRepairParts(partsList);
        }
        return repairRecord;
    }

    @Override
    public Page selectRecordVoPage(Query query, Long maintId, Map<String,Object> params) {
        query.setRecords(rrRepairRecordMapper.selectRecordVoPage(query,maintId,params));
        return query;
    }

    @Override
    public RecordVO selectRecordVOByRecordId(String recordId,Long maintId) {
        return rrRepairRecordMapper.selectRecordVOByRecordId(recordId,maintId);
    }
}
