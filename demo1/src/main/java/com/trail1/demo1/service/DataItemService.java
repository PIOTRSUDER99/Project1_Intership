package com.trail1.demo1.service;


import com.trail1.demo1.dao.DataItemDao;
import com.trail1.demo1.model.DataItem;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;


import java.util.List;
import java.util.UUID;

@Service
public class DataItemService {

    private final DataItemDao dataItemDao;

    @Autowired
    public DataItemService(@Qualifier("DataDao") DataItemDao dataItemDao)
    {
        this.dataItemDao = dataItemDao;
    }

    public boolean addDataItem(DataItem dataItem)
    {
        UUID id = UUID.randomUUID(); //Generate random id
        return dataItemDao.insertDataItem(id, dataItem);
    }

    public DataItem getDataItemById(UUID id)
    {
        return dataItemDao.findDataItemById(id);
    }


    public boolean deleteDataItem(UUID id)
    {
        return dataItemDao.deleteDataItemById(id);
    }

    public boolean updateDataItem(UUID id, DataItem dataItem)
    {
        return dataItemDao.updateDataItemById(id, dataItem);
    }
}
