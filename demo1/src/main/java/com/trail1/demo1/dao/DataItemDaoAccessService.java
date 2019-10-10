package com.trail1.demo1.dao;

import com.trail1.demo1.model.DataItem;

import java.util.List;
import java.util.Set;
import java.util.UUID;
import java.util.Iterator;

import java.util.HashMap;

import org.springframework.stereotype.Repository;


@Repository("DataDao")
public class DataItemDaoAccessService implements DataItemDao {

    private static HashMap<UUID, DataItem> DB = new HashMap<UUID, DataItem>();


    @Override
    public boolean insertDataItem(UUID id, DataItem dataItem) {
        DB.put(id, dataItem);
        return true;
    }


    //PROBLEMATIC FOR SOME REASON!!!!!!!!!!!!!!!!!!!!!!!!!!
    @Override
    public List<DataItem> getAllDataItems() {
        List<DataItem> DataItemsList = new List<DataItem>;

        Set setOfKeys = DB.keySet();
        Iterator iter = setOfKeys.iterator();

        while (iter.hasNext())
        {
            UUID keyValue = (UUID)iter.next();
            DataItemsList.add(DB.get(keyValue));
        }
        return DataItemsList;
      //  return null;
    }


    @Override
    public DataItem findDataItemById(UUID id) {
        return DB.get(id);

    }

    @Override
    public boolean deleteDataItemById(UUID id) {
        DataItem dataItemToDelete = DB.get(id);
        if (dataItemToDelete == null)
        {
            return false;
        }
        else
        {
            DB.remove(id);
        }
        return true;
    }

    @Override
    public boolean updateDataItemById(UUID id, DataItem dataItem) {
        //DataItem toUpdate = findDataItemById(id);
        //if (toUpdate == null) {
         //   return false;
        //}
        //else
        //{
        DataItem oldDataItem = DB.replace(id, dataItem);
        if (oldDataItem == null)
        {
            return false;
        }
        else
        {
            return true;
        }
        //}
    }


}



