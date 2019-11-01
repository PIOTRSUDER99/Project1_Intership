package com.trail1.demo1.dao;

import com.trail1.demo1.model.DataItem;
import javafx.util.Pair;
import org.slf4j.helpers.FormattingTuple;

import java.util.List;
import java.util.UUID;

public interface DataItemDao {

    boolean insertDataItem(UUID id, DataItem dataItem);

    List<Pair<UUID, DataItem>> getAllDataItems();

    default boolean insertDataItem(DataItem dataItem)
    {
        UUID id = UUID.randomUUID();
        return insertDataItem(id, dataItem);
    }

    DataItem findDataItemById(UUID id);

    boolean deleteDataItemById(UUID id);

    boolean updateDataItemById(UUID id, DataItem dataItem);


}
