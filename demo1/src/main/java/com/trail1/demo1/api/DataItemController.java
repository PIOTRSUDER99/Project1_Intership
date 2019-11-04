package com.trail1.demo1.api;

import com.trail1.demo1.model.DataItem;
import com.trail1.demo1.service.DataItemService;


import javafx.util.Pair;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.util.List;
import java.util.UUID;


@RequestMapping("api/v1/data")
@RestController
public class DataItemController {

    //??????????????????????????
   // public DataItemController()
   // {
    //    super();
    //}

    @Autowired
    private DataItemService dataItemService;

    @PostMapping
    public void addDataItem(@Valid @NotNull @RequestBody DataItem dataItem)
    {
        dataItemService.addDataItem(dataItem);
    }

    @PostMapping(path = "{id}")
    public void addDataItemWithId(@PathVariable("id") UUID id, @Valid @NotNull @RequestBody DataItem dataItem)
    {
        dataItemService.addDataItemWithId(id, dataItem);
    }

    @GetMapping
    public List<Pair<UUID, DataItem>> getAllDataItems()
    {
        return dataItemService.getAllDataItems();
    }

    @GetMapping(path = "{id}") //or     @GetMapping(value = "/{id}")
    public DataItem getDataItemById(@PathVariable("id") UUID id)
    {
        return dataItemService.getDataItemById(id);
    }

    @DeleteMapping(path = "{id}")
    public boolean deleteDataItemById(@PathVariable("id") UUID id)
    {
        return dataItemService.deleteDataItem(id);
    }

    @PutMapping(path = "{id}")
    public boolean updateDataItem(@PathVariable("id") UUID id, @Valid @NotNull @RequestBody DataItem alteredDataItem )
    {
        return dataItemService.updateDataItem(id, alteredDataItem);
    }

}
