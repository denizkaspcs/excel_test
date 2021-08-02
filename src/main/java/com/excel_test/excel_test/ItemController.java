package com.excel_test.excel_test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

@RestController
@RequestMapping(value = "/", method = RequestMethod.GET)
public class ItemController {
    @Autowired
    private ItemRepository itemRepository;

    private ExcelReader excelReader = new ExcelReader();

    @GetMapping("/")
    public List<Item> getString() {

        Item[] arr = excelReader.readExcel();
        for (int i = 0; i < 5; i++) {

            itemRepository.save(arr[i]);

        }
        return itemRepository.findAll();
    }
}
