package com.example.demo.controllers;

import com.example.demo.models.ExpertItem;
import com.example.demo.repository.ExpertItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Fedor Danilov 15.11.2021
 */
@Controller
public class MainController {
    @Autowired
    ExpertItemRepository repository;

    @GetMapping
    public String home(){
        List<ExpertItem> expertItems = getAll();
        expertItems = sortAll(expertItems);
        repository.saveAll(expertItems);
        return "index";
    }

    public List<ExpertItem> getAll(){
        return repository.findAll();
    }

    public List<ExpertItem> getExpertItem(String code){
        return repository.findByCode(code);
    }

    public List<ExpertItem> sortAll(List<ExpertItem> expertItems){
        List<ExpertItem> newExpertItem = new ArrayList<>();
        for (ExpertItem item: expertItems) {
            if (item.getCode().length() == 10) {
                if (item.getCode().equals("0000000000")) {
                    item.setPr_prcode(null);
                } else if (item.getCode().startsWith("00000000", 2)) {
                    item.setPr_prcode("0000000000");
                } else {
                    ExpertItem parent = findParent(item);
                    if (parent != null) {
                        item.setPr_prcode(parent.getCode());
                    }
//                    if (item.getData_endactive() != null) {
//                        if (item.getData_startactive().after(item.getData_endactive())) {
//                            assert parent != null;
//                            item.setData_endactive(parent.getData_endactive());
//                        }
//                    }
                }
            }
            newExpertItem.add(item);
        }
        return newExpertItem;
    }

    private boolean isActual(ExpertItem parent, ExpertItem child){
        if (parent.getData_startactive().before(child.getData_startactive()) || parent.getData_startactive().equals(child.getData_startactive())){
            if (parent.getData_endactive() == null && child.getData_endactive() == null) return true;
            if (parent.getData_endactive() != null && child.getData_endactive() == null) return true;
            if (parent.getData_endactive().after(child.getData_endactive()) || parent.getData_endactive().equals(child.getData_endactive())) return true;
            return parent.getData_endactive().before(child.getData_endactive());
        }else{
            return false;
        }
    }

    private ExpertItem findParent(ExpertItem child){
        try {
            ExpertItem result = new ExpertItem();
            String s = child.getCode();
            char[] childChars = s.toCharArray();
            for (int i = childChars.length - 1; i >= 0; i--){
                if (childChars[i] != '0'){
                    childChars[i] = '0';
                    StringBuilder code = new StringBuilder();
                    for (char aChar : childChars) {
                        code.append(aChar);
                    }
                    for (ExpertItem expertItem : getExpertItem(code.toString())) {
                        if (expertItem.getCode().substring(7, 9).equals("00")) return expertItem;
                    }
                }
            }
            return null;
        }
        catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
    }
}
