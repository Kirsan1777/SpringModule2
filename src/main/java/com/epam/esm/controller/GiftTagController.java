package com.epam.esm.controller;

import com.epam.esm.model.dao.impl.LinkTableDAOImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;


/**
 * Class of concatenated tables controller to handle requests and response
 */
@Controller
@RequestMapping("many")
public class GiftTagController {

    private static final String THIRD_PAGE = "many/thirdPage";

    @Autowired
    private final LinkTableDAOImpl linkTableDAO;

    public GiftTagController(LinkTableDAOImpl linkTableDAO) {
        this.linkTableDAO = linkTableDAO;
    }

    @GetMapping("/thirdPage")
    public ModelAndView thirdPage(ModelAndView model) {
        model.addObject("tables", linkTableDAO.getConcatenatedTables(""));
        model.setViewName(THIRD_PAGE);
        return model;
    }

    @GetMapping("/sortDateAsc")
    public ModelAndView sortByDateASC(ModelAndView model) {
        model.addObject("tables", linkTableDAO.getConcatenatedTables(" ORDER BY c.name ASC"));
        model.setViewName(THIRD_PAGE);
        return model;
    }

    @GetMapping("/sortDateDesc")
    public ModelAndView sortByDateDESC(ModelAndView model) {
        model.addObject("tables", linkTableDAO.getConcatenatedTables(" ORDER BY c.name DESC"));
        model.setViewName(THIRD_PAGE);
        return model;
    }

    @GetMapping("/sortTagNameAsc")
    public ModelAndView sortByTagNameASC(ModelAndView model) {
        model.addObject("tables", linkTableDAO.getConcatenatedTables(" ORDER BY t.name ASC"));
        model.setViewName(THIRD_PAGE);
        return model;
    }

    @GetMapping("/sortTagNameDesc")
    public ModelAndView sortByTagNameDESC(ModelAndView model) {
        model.addObject("tables", linkTableDAO.getConcatenatedTables(" ORDER BY t.name DESC"));
        model.setViewName(THIRD_PAGE);
        return model;
    }

    @GetMapping("/findByAllParam")
    public ModelAndView sortByAllParam(@RequestParam(value = "nameTag") String nameTag,
                                 @RequestParam(value = "nameGift") String nameGift,
                                 @RequestParam(value = "typeSort") String typeSort,
                                 @RequestParam(value = "orderBy") String orderBy,
                                 @RequestParam(value = "chooseType") String chooseType,
                                       ModelAndView model) {

        StringBuffer stringBuffer = new StringBuffer();
        int count = 0;
        if (nameTag != null && !nameTag.equals("")) {
            stringBuffer.append(" WHERE t.name = '").append(nameTag).append("'");
            count++;
        }
        if (nameGift != null && chooseType != null && !nameGift.equals("") && !chooseType.equals("")) {
            if (count > 0) {
                stringBuffer.append(" AND ");
            }else{
                stringBuffer.append(" WHERE ");
            }
            stringBuffer.append(chooseType).append(" LIKE '%").append(nameGift).append("%'");
            count++;
        }
        if (!orderBy.equals("")) {
            stringBuffer.append(" ORDER BY ").append(orderBy).append(" ").append(typeSort);
        }
        model.addObject("tables", linkTableDAO.getConcatenatedTables(stringBuffer.toString()));
        model.setViewName(THIRD_PAGE);
        return model;
    }
}
